package com.medical.solution.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
import com.medical.solution.repository.MedicalRepository;

@Component
public class MedicalSolutionManager {

	private static final Logger LOG = Logger.getLogger(MedicalSolutionManager.class);
	private MedicalRepository medicalRepository;

	@Autowired
	public MedicalSolutionManager(MedicalRepository medicalRepository) {
		this.medicalRepository = medicalRepository;
	}

	public void createDoctorTable() {

		LOG.info("Creating Doctor table");
		boolean isCreated = medicalRepository.createMedical(Doctor.class);
		if (isCreated) {
			LOG.info("Doctor table created.");
		} else {
			LOG.info("Doctor table might already exist.");
		}
	}

	public void createPatientTable() {

		LOG.info("Creating Patient table");
		boolean isCreated = medicalRepository.createMedical(Patient.class);
		if (isCreated) {
			LOG.info("Patient table created.");
		} else {
			LOG.info("Patient table might already exist.");
		}
	}

	public void createAppointmentTable() {

		LOG.info("Creating Appointment table");
		boolean isCreated = medicalRepository.createMedical(Appointment.class);
		if (isCreated) {
			LOG.info("Appointment table created.");
		} else {
			LOG.info("Appointment table might already exist.");
		}
	}

	public void createCasesTable() {

		LOG.info("Creating Cases table");
		boolean isCreated = medicalRepository.createMedical(Cases.class);
		if (isCreated) {
			LOG.info("Cases table created.");
		} else {
			LOG.info("Cases table might already exist.");
		}
	}

	public void createCalendarTable() {

		LOG.info("Creating Calendar table");
		boolean isCreated = medicalRepository.createMedical(Calendar.class);
		if (isCreated) {
			LOG.info("Calendar table created.");
		} else {
			LOG.info("Calendar table might already exist.");
		}
	}

	public void createContactTable() {

		LOG.info("Creating Contact table");
		boolean isCreated = medicalRepository.createMedical(Contact.class);
		if (isCreated) {
			LOG.info("Contact table created.");
		} else {
			LOG.info("Contact table might already exist.");
		}
	}

	public void createExpertiseTable() {

		LOG.info("Expertise Cases table");
		boolean isCreated = medicalRepository.createMedical(Expertise.class);
		if (isCreated) {
			LOG.info("Expertise table created.");
		} else {
			LOG.info("Expertise table might already exist.");
		}
	}

	public void createLoginTable() {

		LOG.info("Creating Login table");
		boolean isCreated = medicalRepository.createMedical(Login.class);
		if (isCreated) {
			LOG.info("Login table created.");
		} else {
			LOG.info("Login table might already exist.");
		}
	}

	public void createMessageTable() {

		LOG.info("Creating Message table");
		boolean isCreated = medicalRepository.createMedical(Message.class);
		if (isCreated) {
			LOG.info("Message table created.");
		} else {
			LOG.info("Message table might already exist.");
		}
	}

	public void createNotificationTable() {

		LOG.info("Creating Notification table");
		boolean isCreated = medicalRepository.createMedical(Notification.class);
		if (isCreated) {
			LOG.info("Notification table created.");
		} else {
			LOG.info("Notification table might already exist.");
		}
	}

	public void createTodoListTable() {

		LOG.info("Creating Notification table");
		boolean isCreated = medicalRepository.createMedical(TodoList.class);
		if (isCreated) {
			LOG.info("TodoList table created.");
		} else {
			LOG.info("TodoList table might already exist.");
		}
	}
}
