package com.medical.solution.constant;

import java.util.HashMap;

import com.medical.solution.model.Doctor;

public class Constants {

	public static final String INSERT_DOCTOR = "Insert into doctor values (?,?,?,?,?,?,?)";

	public static final String DOCTOR_MYSQL_TABLE_NAME = "doctor";

	public static final HashMap<Object, String> getPrimaryKeyMap = new HashMap<Object, String>() {
		{
			put(Doctor.class, "dId");
		}
	};
}
