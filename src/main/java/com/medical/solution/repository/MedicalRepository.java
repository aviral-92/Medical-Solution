package com.medical.solution.repository;

import static com.medical.solution.constant.Constants.MEDICAL_SOLUTION_TABLES;
import static com.medical.solution.constant.Constants.GET_MEDICAL_OBJECT;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medical.solution.constant.Constants;
import com.medical.solution.dao.MySQLTemplate;
import com.medical.solution.model.common.Persistable;;

@Repository
public class MedicalRepository {

	private static final Logger LOG = Logger.getLogger(MedicalRepository.class);

	@Autowired
	private MySQLTemplate MySQLTemplate;

	public <T extends Persistable> boolean getAllTables(T t, Class<T> clazz) {
		String tableName = MEDICAL_SOLUTION_TABLES.get(clazz);
		return MySQLTemplate.createTableIfNotExist(t, tableName, clazz);

	}

	public <T extends Persistable> boolean createMedical(Class<T> clazz) {

		LOG.info("createMedical method called");
		String tableName = MEDICAL_SOLUTION_TABLES.get(clazz);
		T t = (T) GET_MEDICAL_OBJECT.get(clazz);
		return MySQLTemplate.createTableIfNotExist(t, tableName, clazz);
	}

	public <T extends Persistable> boolean addMedical(T t, Class<T> clazz) {

		LOG.info("addMedical method called");
		String tableName = MEDICAL_SOLUTION_TABLES.get(clazz);
		return MySQLTemplate.insert(t, tableName, clazz);

	}

	public <T extends Persistable> List<T> getAllMedicals(Class<T> clazz) {

		LOG.info("getAllMedicals method called");
		String tableName = Constants.MEDICAL_SOLUTION_TABLES.get(clazz);
		return MySQLTemplate.getAllRecords(tableName, clazz);
	}

	public <T extends Persistable> T getMedical(String primaryKeyValue, Class<T> clazz) {

		LOG.info("getMedical method called");
		String tableName = Constants.MEDICAL_SOLUTION_TABLES.get(clazz);
		return MySQLTemplate.getRecordOnBasisOfId(primaryKeyValue, tableName, clazz);
	}
}
