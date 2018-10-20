package com.medical.solution.model;

import com.medical.solution.model.common.Persistable;

public class Expertise implements Persistable {

	private String expertiseId;
	private String searchTags;
	private String expertise;
	private Integer approved;

	public String getSearchTags() {
		return searchTags;
	}

	public void setSearchTags(String searchTags) {
		this.searchTags = searchTags;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public Integer getApproved() {
		return approved;
	}

	public void setApproved(Integer approved) {
		this.approved = approved;
	}

	@Override
	public String getId() {
		return expertiseId;
	}

	@Override
	public void setId(String id) {
		this.expertiseId = id;
	}

	@Override
	public String toString() {
		return "Expertise [expertiseId=" + expertiseId + ", searchTags=" + searchTags + ", expertise=" + expertise
				+ ", approved=" + approved + "]";
	}

}
