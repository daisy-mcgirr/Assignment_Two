package model;

import java.io.Serializable;
import java.util.Date;

public class Holiday implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date startDate;
	private Date endDate;
	private Employee emp;

	/**
	 * Declare a default constructor as we also have a loaded one
	 */

	public Holiday() {

	}

	/**
	 * @param startDate
	 * @param endDate
	 * @param emp
	 */
	public Holiday(Date startDate, Date endDate, Employee emp) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.emp = emp;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the employeeID
	 */
	public Employee getEmployee() {
		return emp;
	}

	/**
	 * @param employeeID
	 *            the employeeID to set
	 */
	public void setEmployee(Employee emp) {
		this.emp = emp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee: " + emp.toString() + "\nHoliday start date: : " + startDate + "\nHoliday end date: "
				+ endDate;
	}
}
