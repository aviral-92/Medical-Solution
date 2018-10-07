package com.medical.solution.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.solution.model.Doctor;
import com.medical.solution.repository.DoctorRepository;

@Service
public class DoctorService {

	private static final Logger LOG = Logger.getLogger(DoctorService.class);

	@Autowired
	private DoctorRepository doctorRepository;

	public boolean createtDoctor(Doctor doctor) {

		return doctorRepository.createDoctorTable(doctor);
	}

	public String addDoctor(Doctor doctor) {
		return doctorRepository.addDoctor(doctor);
	}

	public List<Doctor> getAllDoctors() {
		return doctorRepository.getAllDoctors();
	}

	public Doctor getDoctor(String doctorId) {
		LOG.info("-------------getDoctor method called---------------");
		return doctorRepository.getDoctor(doctorId);
	}
}
