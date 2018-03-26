package com.goks.fortune.model;

/**
 * @author Gokul
 *
 */
public class Employee {

	/**
	 * Id of the Employee.
	 */
	private int id;
	/**
	 * Name of the Employee.
	 */
	private String name;
	/**
	 * Previous shift day of the employee.
	 */
	private String previousShiftDate;
	/**
	 * Total number of shifts of the employee.
	 */
	private int totalShifts;
	/**
	 * @return id of the employee.
	 */
	public final int getId() {
		return id;
	}

	/**
	 * @param idEmp employee id.
	 */
	public final void setId(final int idEmp) {
		this.id = idEmp;
	}

	/**
	 * @return name: Name of the employee.
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param nameEmp Name of the employee.
	 */
	public final void setName(final String nameEmp) {
		this.name = nameEmp;
	}

	/**
	 * @return previousShift date.
	 */
	public final String getPreviousShiftDate() {
		return previousShiftDate;
	}

	/**
	 * @param prvShiftDate of employee
	 */
	public final void setPreviousShiftDate(final String prvShiftDate) {
		this.previousShiftDate = prvShiftDate;
	}

	/**
	 * @return total shifts of employee.
	 */
	public final int getTotalShifts() {
		return totalShifts;
	}

	/**
	 * @param totalShiftsEmp of employee.
	 */
	public final void setTotalShifts(final int totalShiftsEmp) {
		this.totalShifts = totalShiftsEmp;
	}

}
