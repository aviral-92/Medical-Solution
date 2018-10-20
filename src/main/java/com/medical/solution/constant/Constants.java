package com.medical.solution.constant;

import java.util.HashMap;
import java.util.Map;

import com.medical.solution.model.Doctor;
import com.medical.solution.model.Patient;
import com.medical.solution.model.common.Persistable;

public class Constants {

	public static final String INSERT_DOCTOR = "Insert into doctor values (?,?,?,?,?,?,?)";

	public static final String DOCTOR_MYSQL_TABLE_NAME = "doctor";
	public static final String PATIENT_MYSQL_TABLE_NAME = "patient";

	public static final HashMap<Object, String> GET_PRIMARY_KEY_MAP = new HashMap<Object, String>() {
		{
			put(Doctor.class, "dId");
			put(Patient.class, "pId");
		}
	};

	public static final Map<Class, String> MEDICAL_SOLUTION_TABLES = new HashMap<Class, String>() {
		{
			put(Doctor.class, DOCTOR_MYSQL_TABLE_NAME);
			put(Patient.class, PATIENT_MYSQL_TABLE_NAME);
		}
	};

	public static final Map<Class, Object> GET_MEDICAL_OBJECT = new HashMap<Class, Object>() {
		{
			put(Doctor.class, new Doctor());
			put(Patient.class, new Patient());
		}
	};
}
