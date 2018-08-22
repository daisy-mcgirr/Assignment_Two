package model;

import java.io.Serializable;

public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int deptID;
	private String deptName;
	private int noOfEmployees;

	/**
	 * Declare a default constructor as we also have a loaded one
	 */
	public Department() {

	}

	/**
	 * @param deptID
	 * @param deptName
	 * @param noOfEmployees
	 */
	public Department(int deptID, String deptName, int noOfEmployees) {
		this.deptID = deptID;
		this.deptName = deptName;
		this.noOfEmployees = noOfEmployees;
	}

	/**
	 * @return the deptID
	 */
	public int getDeptID() {
		return deptID;
	}

	/**
	 * @param deptID the deptID to set
	 */
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the noOfEmployees
	 */
	public int getNoOfEmployees() {
		return noOfEmployees;
	}

	/**
	 * @param noOfEmployees the noOfEmployees to set
	 */
	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nDepartment ID: " + deptID + "\nDepatment Name: " + deptName + "\nNumber of employees: "
				+ noOfEmployees;
	}

	/**
	 * equals method, checks deptID & deptName match
	 */
	@Override
	public boolean equals(Object temp) {

		if (temp == null) {
			return false;
		}

		if (temp instanceof Department) {

			Department dept = (Department) temp;

			if (this.deptID == dept.deptID && this.deptName.equalsIgnoreCase(dept.deptName)) {

				return true;
			} else {

				// return false if one of the variables does not match
				return false;
			}
		}

		// return false as default as it means that the check was
		// completed
		return false;
	}

}
