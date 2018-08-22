package model;

import java.io.Serializable;
import java.util.Date;

public abstract class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * The Employee class is our super class from this class we will produce
	 * subclasses of different types of Employees
	 */
	private int id;
	private static int nextID = 101;
	private Name name;
	private Department dept;
	private String phoneNumber;
	private Date startDate;
	private double monthlyPay;

	/**
	 * Default constructor that will set the id for any new Employees created
	 */
	public Employee() {
		this.id = nextID++;
	}

	/**
	 * @param name
	 * @param dept
	 * @param phoneNumber
	 * @param startDate
	 * @param monthlyPay
	 */
	public Employee(Name name, Department dept, String phoneNumber, Date startDate) {
		this.id = nextID++;
		this.name = name;
		this.dept = dept;
		this.phoneNumber = phoneNumber;
		this.startDate = startDate;
		this.monthlyPay = 0;
	}

	public static void setNextIdNumber(int update) {
		nextID = update;
	}

	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * @return the dept
	 */
	public Department getDept() {
		return dept;
	}

	/**
	 * @param dept the dept to set
	 */
	public void setDept(Department dept) {
		this.dept = dept;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the monthlyPay
	 */
	public double getMonthlyPay() {
		return monthlyPay;
	}

	/**
	 * @param monthlyPay the monthlyPay to set
	 */
	public void setMonthlyPay(double monthlyPay) {
		this.monthlyPay = monthlyPay;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee ID: " + id + "\nName: " + name + "\nDeptartment: " + dept + "\nPhoneNumber: " + phoneNumber
				+ "\nStart Date: " + startDate;
	}

}
