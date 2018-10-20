package com.medical.solution.model;

import java.util.Date;

import com.medical.solution.model.common.Persistable;

public class Cases implements Persistable {

	private String caseId;
	private Integer patientId;
	private Integer doctorId;
	private String precaution;
	private Date created_Date;
	private Integer closed;

	@Override
	public String getId() {
		return caseId;
	}

	@Override
	public void setId(String id) {
		this.caseId = id;
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

	public String getPrecaution() {
		return precaution;
	}

	public void setPrecaution(String precaution) {
		this.precaution = precaution;
	}

	public Date getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(Date created_Date) {
		this.created_Date = created_Date;
	}

	public Integer getClosed() {
		return closed;
	}

	public void setClosed(Integer closed) {
		this.closed = closed;
	}

	@Override
	public String toString() {
		return "Cases [caseId=" + caseId + ", patientId=" + patientId + ", doctorId=" + doctorId + ", precaution="
				+ precaution + ", created_Date=" + created_Date + ", closed=" + closed + "]";
	}

}
