package com.medical.solution.model;

import java.util.Date;

import com.medical.solution.model.common.Persistable;

public class Doctor implements Persistable {

	private String dId;
	private String name;
	private String mobile;
	private String aadhaar;
	private String clinic;
	private String homeAddress;
	private String highestDegree;
	private String expertise;
	private String selfDescription;
	private Integer isGoverment;
	private Integer fee;
	private Integer freeDay;
	private String email;
	private String gender;
	private String state;
	private Date dateOfBrith;
	private String timing;
	private Integer tandCAccepted;
	private Integer verified;
	private String profilePicPath;
	private Date createdDate;
	private Date updatedDate;
	private String doctorAddress;
	private String description;
	private String password;

	@Override
	public String getId() {
		return dId;
	}

	@Override
	public void setId(String id) {
		this.dId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}

	public String getClinic() {
		return clinic;
	}

	public void setClinic(String clinic) {
		this.clinic = clinic;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getHighestDegree() {
		return highestDegree;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getSelfDescription() {
		return selfDescription;
	}

	public void setSelfDescription(String selfDescription) {
		this.selfDescription = selfDescription;
	}

	public Integer getIsGoverment() {
		return isGoverment;
	}

	public void setIsGoverment(Integer isGoverment) {
		this.isGoverment = isGoverment;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public Integer getFreeDay() {
		return freeDay;
	}

	public void setFreeDay(Integer freeDay) {
		this.freeDay = freeDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDateOfBrith() {
		return dateOfBrith;
	}

	public void setDateOfBrith(Date dateOfBrith) {
		this.dateOfBrith = dateOfBrith;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public Integer getTandCAccepted() {
		return tandCAccepted;
	}

	public void setTandCAccepted(Integer tandCAccepted) {
		this.tandCAccepted = tandCAccepted;
	}

	public Integer getVerified() {
		return verified;
	}

	public void setVerified(Integer verified) {
		this.verified = verified;
	}

	public String getProfilePicPath() {
		return profilePicPath;
	}

	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDoctorAddress() {
		return doctorAddress;
	}

	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	@Override
	public String toString() {
		return "Doctor [dId=" + dId + ", name=" + name + ", mobile=" + mobile + ", aadhaar=" + aadhaar + ", clinic="
				+ clinic + ", homeAddress=" + homeAddress + ", highestDegree=" + highestDegree + ", expertise="
				+ expertise + ", selfDescription=" + selfDescription + ", isGoverment=" + isGoverment + ", fee=" + fee
				+ ", freeDay=" + freeDay + ", email=" + email + ", gender=" + gender + ", state=" + state
				+ ", dateOfBrith=" + dateOfBrith + ", timing=" + timing + ", tandCAccepted=" + tandCAccepted
				+ ", verified=" + verified + ", profilePicPath=" + profilePicPath + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", doctorAddress=" + doctorAddress + ", description=" + description
				+ ", password=" + password + "]";
	}

}
