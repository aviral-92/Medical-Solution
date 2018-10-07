package com.medical.solution.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
			this.datasource = dataSource;
			this.connection = datasource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public <T extends Persistable> boolean createTableIfNotExist(T t, String tableName, Class<T> entityClass) {

		StringBuffer sb = new StringBuffer("CREATE TABLE IF NOT EXISTS " + tableName + " (");
		boolean insertSuccess = false;
		Statement stmt = null;
		try {
			List<Field> fields = getFields(entityClass);

			for (Field field : fields) {
				Object value = field.get(t);
				LOG.info(field.getName());
				LOG.info("\t" + field.getType().getName());
				LOG.info("\t" + value + "\n");
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
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			insertSuccess = false;
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return insertSuccess;
	}

	public <T extends Persistable> boolean insert(T t, String tableName, Class<T> entityClass) {

		boolean isInsert = false;
		StringBuilder sb = new StringBuilder("INSERT INTO " + tableName + " (");
		List<Field> fields = getFields(entityClass);
		List<Object> listOfValues = new ArrayList<>();
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
			PreparedStatement ps = connection.prepareStatement(sb.toString());
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
		}
		return isInsert;
	}

	private <T extends Persistable> List<Field> getFields(Class<T> entityClass) {

		Field[] allFields = entityClass.getDeclaredFields();
		List<Field> fields = Arrays.stream(allFields).collect(Collectors.toList());
		fields.forEach(f -> f.setAccessible(true));
		return fields;
	}

}
