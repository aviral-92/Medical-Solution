package com.medical.solution.model;

import com.medical.solution.model.common.Persistable;

public class Message implements Persistable {

	private String id;
	private Integer patientId;
	private Integer doctorId;
	private String message;
	private int status;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", patientId=" + patientId + ", doctorId=" + doctorId + ", message=" + message
				+ "]";
	}

}
