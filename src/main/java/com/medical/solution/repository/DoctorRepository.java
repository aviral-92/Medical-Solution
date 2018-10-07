package com.medical.solution.repository;

import static com.medical.solution.constant.Constants.DOCTOR_MYSQL_TABLE_NAME;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medical.solution.dao.MySQLTemplate;
import com.medical.solution.model.Doctor;;

@Repository
public class DoctorRepository {

	private static final Logger LOG = Logger.getLogger(DoctorRepository.class);

	@Autowired
	private MySQLTemplate MySQLTemplate;

	public boolean createDoctorTable(Doctor doctor) {
		LOG.info("createDoctorTable method called");
		return MySQLTemplate.createTableIfNotExist(doctor, DOCTOR_MYSQL_TABLE_NAME, Doctor.class);
	}

	public String addDoctor(Doctor doctor) {

		boolean response = MySQLTemplate.insert(doctor, DOCTOR_MYSQL_TABLE_NAME, Doctor.class);
		if (response) {
			return "Success";
		}
		return "Failed";
	}

	public List<Doctor> getAllDoctors() {
		return MySQLTemplate.getAllRecords(DOCTOR_MYSQL_TABLE_NAME, Doctor.class);
	}

	public Doctor getDoctor(String primaryKeyValue) {
		LOG.info("getDoctor method called");
		return MySQLTemplate.getRecordOnBasisOfId(primaryKeyValue, DOCTOR_MYSQL_TABLE_NAME, Doctor.class);
	}
}
