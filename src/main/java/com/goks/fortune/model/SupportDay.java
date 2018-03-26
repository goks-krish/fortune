package com.goks.fortune.model;

/**
 * @author Gokul
 *
 */
public class SupportDay {

	/**
	 * Id of the day.
	 */
	private int id;
	/**
	 * Today date.
	 */
	private String today;
	/**
	 * Yesterday date.
	 */
	private String yesterday;
	/**
	 * First shift employee id.
	 */
	private int firstShiftEmpId;
	/**
	 * Last shift employee id.
	 */
	private int lastShiftEmpId;
	/**
	 * Total employee count.
	 */
	private int totalEmployeeCount;
	/**
	 * Verify if the allotment is valid.
	 */
	private boolean complete;

	/**
	 * @return today date.
	 */
	public final String getToday() {
		return today;
	}

	/**
	 * @param todayDate as today date.
	 */
	public final void setToday(final String todayDate) {
		this.today = todayDate;
	}

	/**
	 * @return first shift employee id.
	 */
	public final int getFirstShiftEmpId() {
		return firstShiftEmpId;
	}

	/**
	 * @param firstShiftEId employee of first shift.
	 */
	public final void setFirstShiftEmpId(final int firstShiftEId) {
		this.firstShiftEmpId = firstShiftEId;
	}

	/**
	 * @return last shift employee.
	 */
	public final int getLastShiftEmpId() {
		return lastShiftEmpId;
	}

	/**
	 * @param lastShiftEId of employee.
	 */
	public final void setLastShiftEmpId(final int lastShiftEId) {
		this.lastShiftEmpId = lastShiftEId;
	}

	/**
	 * @return id of day.
	 */
	public final int getId() {
		return id;
	}

	/**
	 * @param idNo of Day.
	 */
	public final void setId(final int idNo) {
		this.id = idNo;
	}

	/**
	 * @return previous day date.
	 */
	public final String getYesterday() {
		return yesterday;
	}

	/**
	 * @param yesterdayDate of previous day.
	 */
	public final void setYesterday(final String yesterdayDate) {
		this.yesterday = yesterdayDate;
	}

	/**
	 * @return total employee count.
	 */
	public final int getTotalEmployeeCount() {
		return totalEmployeeCount;
	}

	/**
	 * @param totalEmp count.
	 */
	public final void setTotalEmployeeCount(final int totalEmp) {
		this.totalEmployeeCount = totalEmp;
	}

	/**
	 * @return completed or not.
	 */
	public final boolean isComplete() {
		return complete;
	}

	/**
	 * @param completed verified or not.
	 */
	public final void setComplete(final boolean completed) {
		this.complete = completed;
	}

}
