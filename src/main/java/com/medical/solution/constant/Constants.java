package com.medical.solution.constant;

import java.util.HashMap;
import java.util.Map;

import com.medical.solution.model.Appointment;
import com.medical.solution.model.Calendar;
import com.medical.solution.model.Cases;
import com.medical.solution.model.Contact;
import com.medical.solution.model.Doctor;
import com.medical.solution.model.Expertise;
import com.medical.solution.model.Login;
import com.medical.solution.model.Message;
import com.medical.solution.model.Notification;
import com.medical.solution.model.Patient;
import com.medical.solution.model.TodoList;

public class Constants {

	public static final String INSERT_DOCTOR = "Insert into doctor values (?,?,?,?,?,?,?)";

	public static final String APPOINTMENT_MYSQL_TABLE_NAME = "appointment";
	public static final String CALENDAR_MYSQL_TABLE_NAME = "calendar";
	public static final String CASES_MYSQL_TABLE_NAME = "cases";
	public static final String CONTACT_MYSQL_TABLE_NAME = "contact";
	public static final String DOCTOR_MYSQL_TABLE_NAME = "doctor";
	public static final String EXPERTISE_MYSQL_TABLE_NAME = "expertise";
	public static final String LOGIN_MYSQL_TABLE_NAME = "login";
	public static final String MESSAGE_MYSQL_TABLE_NAME = "message";
	public static final String NOTIFICATION_MYSQL_TABLE_NAME = "notification";
	public static final String PATIENT_MYSQL_TABLE_NAME = "patient";
	public static final String TODOLIST_MYSQL_TABLE_NAME = "todolist";

	@SuppressWarnings({ "serial" })
	public static final HashMap<Object, String> GET_PRIMARY_KEY_MAP = new HashMap<Object, String>() {
		{
			put(Doctor.class, "dId");
			put(Patient.class, "pId");
			put(Patient.class, "appointmentId");
		}
	};

	@SuppressWarnings({ "rawtypes", "serial" })
	public static final Map<Class, String> MEDICAL_SOLUTION_TABLES = new HashMap<Class, String>() {
		{
			put(Doctor.class, DOCTOR_MYSQL_TABLE_NAME);
			put(Patient.class, PATIENT_MYSQL_TABLE_NAME);
			put(Appointment.class, APPOINTMENT_MYSQL_TABLE_NAME);
			put(Calendar.class, CALENDAR_MYSQL_TABLE_NAME);
			put(Cases.class, CASES_MYSQL_TABLE_NAME);
			put(Contact.class, CONTACT_MYSQL_TABLE_NAME);
			put(Expertise.class, EXPERTISE_MYSQL_TABLE_NAME);
			put(Login.class, LOGIN_MYSQL_TABLE_NAME);
			put(Message.class, MESSAGE_MYSQL_TABLE_NAME);
			put(Notification.class, NOTIFICATION_MYSQL_TABLE_NAME);
			put(TodoList.class, TODOLIST_MYSQL_TABLE_NAME);
		}
	};

	@SuppressWarnings({ "rawtypes", "serial" })
	public static final Map<Class, Object> GET_MEDICAL_OBJECT = new HashMap<Class, Object>() {

		{
			put(Doctor.class, new Doctor());
			put(Patient.class, new Patient());
			put(Appointment.class, new Appointment());
			put(Calendar.class, new Calendar());
			put(Cases.class, new Cases());
			put(Contact.class, new Contact());
			put(Expertise.class, new Expertise());
			put(Login.class, new Login());
			put(Message.class, new Message());
			put(Notification.class, new Notification());
			put(TodoList.class, new TodoList());
		}
	};
}
