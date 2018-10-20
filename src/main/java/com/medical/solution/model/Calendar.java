package com.medical.solution.model;

import java.util.Date;

import com.medical.solution.model.common.Persistable;

public class Calendar implements Persistable {

	private String calendarId;
	private Integer calendarEventId;
	private String calendarTitle;
	private Date startDate;
	private Date endDate;
	private Integer pId;
	private Integer dId;

	@Override
	public String getId() {
		return calendarId;
	}

	@Override
	public void setId(String id) {
		this.calendarId = id;
	}

	public Integer getCalendarEventId() {
		return calendarEventId;
	}

	public void setCalendarEventId(Integer calendarEventId) {
		this.calendarEventId = calendarEventId;
	}

	public String getCalendarTitle() {
		return calendarTitle;
	}

	public void setCalendarTitle(String calendarTitle) {
		this.calendarTitle = calendarTitle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}

}
