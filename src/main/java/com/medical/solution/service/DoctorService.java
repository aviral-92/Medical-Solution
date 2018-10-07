package com.medical.solution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.solution.model.Doctor;
import com.medical.solution.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	public boolean createtDoctor(Doctor doctor) {

		return doctorRepository.createDoctorTable(doctor);
	}

	public String addDoctor(Doctor doctor) {
		return doctorRepository.addDoctor(doctor);
	}
}
