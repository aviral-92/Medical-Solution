package com.medical.solution.model;

import java.util.Date;

import com.medical.solution.model.common.Persistable;

public class Appointment implements Persistable {

	private String appointmentId;
	private Integer dId;
	private Integer pId;
	private Date appointmentDate;
	private String appointmentDesc;
	private Date createdDate;
	private String status;
	private Patient patient;
	private Doctor doctor;

	@Override
	public String getId() {
		return appointmentId;
	}

	@Override
	public void setId(String id) {
		this.appointmentId = id;
	}

	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentDesc() {
		return appointmentDesc;
	}

	public void setAppointmentDesc(String appointmentDesc) {
		this.appointmentDesc = appointmentDesc;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", dId=" + dId + ", pId=" + pId + ", appointmentDate="
				+ appointmentDate + ", appointmentDesc=" + appointmentDesc + ", createdDate=" + createdDate
				+ ", status=" + status + ", patient=" + patient + ", doctor=" + doctor + "]";
	}

}
