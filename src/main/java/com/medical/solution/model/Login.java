package com.medical.solution.model;

import java.util.Date;

import com.medical.solution.model.common.Persistable;

public class Login implements Persistable {

	private String loginId;
	private String mobile;
	private String password;
	private String aadhaar;
	private String email;
	private String type;
	private boolean isEncode;
	private Integer typeId;
	private Date createDate;
	private Date updatedDate;

	@Override
	public String getId() {
		return loginId;
	}

	@Override
	public void setId(String id) {
		this.loginId = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public boolean isEncode() {
		return isEncode;
	}

	public void setEncode(boolean isEncode) {
		this.isEncode = isEncode;
	}

	public String getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", mobile=" + mobile + ", password=" + password + ", aadhaar=" + aadhaar
				+ ", email=" + email + ", type=" + type + ", isEncode=" + isEncode + ", typeId=" + typeId
				+ ", createDate=" + createDate + ", updatedDate=" + updatedDate + "]";
	}
}
