package com.medical.solution.dao;

import static com.medical.solution.constant.Constants.GET_PRIMARY_KEY_MAP;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medical.solution.model.common.Persistable;

@Component
public class MySQLTemplate {

	private DataSource datasource;

	private Connection connection;

	private static final Logger LOG = Logger.getLogger(MySQLTemplate.class);

	@Autowired
	public MySQLTemplate(DataSource dataSource) {
		try {
			LOG.info(dataSource);
			this.datasource = dataSource;
			this.connection = datasource.getConnection();
			LOG.info(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public <T extends Persistable> boolean createTableIfNotExist(T t, String tableName, Class<T> entityClass) {

		LOG.info("Entered into createTableIfNotExist method");
		StringBuffer sb = new StringBuffer("CREATE TABLE IF NOT EXISTS " + tableName + " (");
		boolean insertSuccess = false;
		Statement stmt = null;
		try {
			List<Field> fields = getFields(entityClass);

			for (Field field : fields) {
				if (field.getType().getName().contains("String")) {
					sb.append(field.getName() + " " + "VARCHAR(45), ");
				} else if (field.getType().getName().contains("Integer")) {
					sb.append(field.getName() + " " + "INT, ");
				} else if (field.getType().getName().contains("Date")) {
					sb.append(field.getName() + " " + "DATETIME, ");
				}
			}
			sb = sb.deleteCharAt(sb.length() - 2);
			sb.append(");");
			LOG.info(sb);
			stmt = connection.createStatement();
			stmt.executeUpdate(sb.toString());
			insertSuccess = true;
			LOG.info("------Successfully created table with " + tableName);
		} catch (SQLException e) {
			e.printStackTrace();
			insertSuccess = false;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			insertSuccess = false;
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		LOG.info("exit from createTableIfNotExist method");
		return insertSuccess;
	}

	public <T extends Persistable> boolean insert(T t, String tableName, Class<T> entityClass) {

		LOG.info("Entered into insert method");
		boolean isInsert = false;
		StringBuilder sb = new StringBuilder("INSERT INTO " + tableName + " (");
		List<Field> fields = getFields(entityClass);
		List<Object> listOfValues = new ArrayList<>();
		PreparedStatement ps = null;
		try {
			for (Field field : fields) {
				Object value = field.get(t);
				if (value != null) {
					sb.append(field.getName() + ",");
					listOfValues.add(value);
				}
			}
			sb = sb.deleteCharAt(sb.length() - 1);
			sb.append(") VALUES (");
			for (int i = 1; i <= listOfValues.size(); i++) {
				sb.append("?,");
			}
			sb = sb.deleteCharAt(sb.length() - 1);
			sb.append(");");
			LOG.info(sb);
			ps = connection.prepareStatement(sb.toString());
			int j = 1;
			for (int i = 0; i < listOfValues.size(); i++) {
				ps.setObject(j, listOfValues.get(i));
				j++;
			}
			int i = ps.executeUpdate();
			if (i > 0) {
				isInsert = true;
				LOG.info(isInsert);
				LOG.info("Successfully inserted record in table " + tableName);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		LOG.info("exit from insert method");
		return isInsert;
	}

	public <T extends Persistable> List<T> getAllRecords(String table, Class<T> entityClass) {

		LOG.info("getAllRecords method called....");
		String query = "SELECT * FROM " + table + ";";
		LOG.info(query);
		List<T> queryResults = new ArrayList<>();
		Map<String, Field> fieldsMap = getFieldsMap(entityClass);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(query);
			getAllRecords(rs, fieldsMap, queryResults, entityClass);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		LOG.info("exit from getAllRecords method....");
		return queryResults;
	}

	public <T extends Persistable> T getRecordOnBasisOfId(String primaryKeyValue, String table, Class<T> entityClass) {

		LOG.info("getRecord method called....");
		String primaryKey = GET_PRIMARY_KEY_MAP.get(entityClass);
		StringBuilder sb = new StringBuilder("SELECT * FROM " + table + " where " + primaryKey + " = ? ;");
		LOG.info(sb);
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, Field> fieldsMap = getFieldsMap(entityClass);
		try {
			ps = connection.prepareStatement(sb.toString());
			ps.setObject(1, primaryKeyValue);
			rs = ps.executeQuery();
			while (rs.next()) {
				return getRecord(entityClass, fieldsMap, rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		T t = null;
		try {
			t = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return t;
	}

	private <T extends Persistable> T getRecord(Class<T> entityClass, Map<String, Field> fieldsMap, ResultSet rs) {

		T t = null;
		try {
			t = (T) entityClass.newInstance();
			for (String keySet : fieldsMap.keySet()) {
				Object resultSetValue = rs.getObject(keySet);
				if (resultSetValue != null) {
					Field field = fieldsMap.get(keySet);
					Object convertedValue = null;
					convertedValue = getValueForType(String.valueOf(resultSetValue), field.getType().getSimpleName());
					field.set(t, convertedValue);
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return t;
	}

	private <T extends Persistable> void getAllRecords(ResultSet rs, Map<String, Field> fieldsMap, List<T> queryResults,
			Class<T> entityClass) {

		LOG.info("Entered into private getAllRecords method.....");
		try {
			while (rs.next()) {
				T t = getRecord(entityClass, fieldsMap, rs);
				queryResults.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		LOG.info("exit from private getAllRecords method.....");
	}

	private <T extends Persistable> List<Field> getFields(Class<T> entityClass) {

		LOG.info("-----getFields method called");
		Field[] allFields = entityClass.getDeclaredFields();
		List<Field> fields = Arrays.stream(allFields).collect(Collectors.toList());
		fields.forEach(f -> f.setAccessible(true));
		return fields;
	}

	private <T extends Persistable> Map<String, Field> getFieldsMap(Class<T> entityClass) {

		Map<String, Field> fieldsMap = new HashMap<String, Field>();
		Field[] fields = entityClass.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			fieldsMap.put(field.getName(), field);
		}
		return fieldsMap;
	}

	private Object getValueForType(String valueToBeSet, String type) throws ParseException {

		switch (type) {

		case "String":
			return valueToBeSet;

		case "short":
		case "Short":
			return Short.valueOf(valueToBeSet);

		case "long":
		case "Long":
			return Long.valueOf(valueToBeSet);

		case "int":
		case "Integer":
			return Integer.valueOf(valueToBeSet);

		case "Date":
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			return formatter.parse(valueToBeSet);

		default:
			throw new IllegalArgumentException("Unsupported Field type: " + type + " value: [ " + valueToBeSet + " ]");
		}
	}
}
