package com.medical.solution.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.solution.dao.repository.MedicalRepository;
import com.medical.solution.model.Doctor;

@Service
public class DoctorService {

	private static final Logger LOG = Logger.getLogger(DoctorService.class);

	@Autowired
	private MedicalRepository medicalRepository;

	public boolean createtDoctor(Doctor doctor) {

		return medicalRepository.createMedical(Doctor.class);
	}

	public String addDoctor(Doctor doctor) {
		boolean isAdded = medicalRepository.addMedical(doctor, Doctor.class);
		if (isAdded) {
			return "Success";
		} else {
			return "failed";
		}
	}

	public List<Doctor> getAllDoctors() {
		return medicalRepository.getAllMedicals(Doctor.class);
	}

	public Doctor getDoctor(String doctorId) {
		LOG.info("-------------getDoctor method called---------------");
		return medicalRepository.getMedical(doctorId, Doctor.class);
	}
}
