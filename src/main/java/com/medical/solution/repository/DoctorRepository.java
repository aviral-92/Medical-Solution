package com.medical.solution.repository;

import static com.medical.solution.constant.Constants.DOCTOR_MYSQL_TABLE_NAME;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medical.solution.dao.MySQLTemplate;
import com.medical.solution.model.Doctor;;

@Repository
public class DoctorRepository {

	@Autowired
	private MySQLTemplate MySQLTemplate;

	public boolean createDoctorTable(Doctor doctor) {

		return MySQLTemplate.createTableIfNotExist(doctor, DOCTOR_MYSQL_TABLE_NAME, Doctor.class);
	}

	public String addDoctor(Doctor doctor) {

		boolean response = MySQLTemplate.insert(doctor, DOCTOR_MYSQL_TABLE_NAME, Doctor.class);
		if (response) {
			return "Success";
		}
		return "Failed";
	}
	
	public List<Doctor> getAllDoctors(){
		return MySQLTemplate.getAllRecords(DOCTOR_MYSQL_TABLE_NAME, Doctor.class);
	}
}
