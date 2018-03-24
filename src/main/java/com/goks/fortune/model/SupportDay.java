package com.goks.fortune.model;

public class SupportDay {
	
	private int id;
	private String today;
	private String yesterday;
	private int firstShiftEmpId;
	private int lastShiftEmpId;
	private int totalEmployeeCount;
	private boolean complete;
	
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public int getFirstShiftEmpId() {
		return firstShiftEmpId;
	}
	public void setFirstShiftEmpId(int firstShiftEmpId) {
		this.firstShiftEmpId = firstShiftEmpId;
	}
	public int getLastShiftEmpId() {
		return lastShiftEmpId;
	}
	public void setLastShiftEmpId(int lastShiftEmpId) {
		this.lastShiftEmpId = lastShiftEmpId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYesterday() {
		return yesterday;
	}
	public void setYesterday(String yesterday) {
		this.yesterday = yesterday;
	}
	public int getTotalEmployeeCount() {
		return totalEmployeeCount;
	}
	public void setTotalEmployeeCount(int totalEmployeeCount) {
		this.totalEmployeeCount = totalEmployeeCount;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}

}
