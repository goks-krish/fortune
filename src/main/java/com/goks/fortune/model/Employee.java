package com.goks.fortune.model;

public class Employee {

	private int id;
	private String name;
	private String previousShiftDate;
	private int totalShifts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreviousShiftDate() {
		return previousShiftDate;
	}

	public void setPreviousShiftDate(String previousShiftDate) {
		this.previousShiftDate = previousShiftDate;
	}

	public int getTotalShifts() {
		return totalShifts;
	}

	public void setTotalShifts(int totalShifts) {
		this.totalShifts = totalShifts;
	}

}
