package com.medical.solution.model;

import com.medical.solution.model.common.Persistable;

public class Notification implements Persistable {

	private String id;
	private Integer patientId;
	private Integer doctorId;
	private String notification;
	private Integer status;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
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

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", patientId=" + patientId + ", doctorId=" + doctorId + ", notification="
				+ notification + ", status=" + status + "]";
	}

}
