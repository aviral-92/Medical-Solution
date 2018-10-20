package com.medical.solution.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medical.solution.model.Doctor;
import com.medical.solution.model.Patient;
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
}
