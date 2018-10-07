package com.medical.solution.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medical.solution.model.Doctor;
import com.medical.solution.service.DoctorService;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@RequestMapping("/create")
	public String createDoctorTable() {

		Doctor doctor = new Doctor();
		boolean status = doctorService.createtDoctor(doctor);
		if (status) {
			return "Successfully created the table";
		} else {
			return "please try again";
		}
	}

	@RequestMapping("/add")
	public String addDoctor() {

		Doctor doctor = new Doctor();
		doctor.setAadhaar("Adhaar");
		doctor.setClinic("Clinic");
		doctor.setCreatedDate(new Date());
		doctor.setDescription("Desc");
		doctor.setEmail("abc@mail.com");
		doctor.setExpertise("Heart");
		doctor.setFee(150);
		doctor.setFreeDay(1);
		doctor.setGender("Male");
		doctor.setHighestDegree("MBBS");
		doctor.setHomeAddress("Delhi");
		doctor.setId("2");
		doctor.setIsGoverment(1);
		doctor.setMobile("8524585450");
		doctor.setName("Aviral");
		doctor.setPassword("Hello");
		doctor.setProfilePicPath("path");
		doctor.setSelfDescription("SelfDesc");
		doctor.setVerified(1);
		return doctorService.addDoctor(doctor);
	}

	@RequestMapping("/getAllDoctors")
	public List<Doctor> getAllDoctors() {
		return doctorService.getAllDoctors();
	}
	
	@RequestMapping("/getDoctor/{dId}")
	public Doctor getDoctor(@PathVariable String dId){
		return doctorService.getDoctor(dId);
	}
}
