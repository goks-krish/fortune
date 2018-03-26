package com.goks.fortune.model;

/**
 * @author Gokul
 *
 */
public class DailySchedule {
	/**
	 * Date of the day.
	 */
	private String date;
	/**
	 * Firstshift employee.
	 */
	private String firstShift;
	/**
	 * Last shift employee.
	 */
	private String lastShift;

	/**
	 * @return date of the target day.
	 */
	public final String getDate() {
		return date;
	}

	/**
	 * @param dateToday for target day.
	 */
	public final void setDate(final String dateToday) {
		this.date = dateToday;
	}

	/**
	 * @return firstshift employee id.
	 */
	public final String getFirstShift() {
		return firstShift;
	}

	/**
	 * @param firstShiftEmp id.
	 */
	public final void setFirstShift(final String firstShiftEmp) {
		this.firstShift = firstShiftEmp;
	}

	/**
	 * @return lastshift employee.
	 */
	public final String getLastShift() {
		return lastShift;
	}

	/**
	 * @param lastShiftEmp id.
	 */
	public final void setLastShift(final String lastShiftEmp) {
		this.lastShift = lastShiftEmp;
	}

}
