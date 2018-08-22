package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import file_handling.DeptStorage;
import file_handling.HolidayStorage;
import file_handling.Storage;
import menus.MainMenu;
import menus.PaymentMenu;
import services.EmployeeServices;

public class Manager extends Employee implements EmployeeServices {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int noOfStaff;
	private double salary;
	private double bonus;

	/**
	 * Declare a default constructor as we also have a loaded one
	 */
	public Manager() {
		super();
	}

	/**
	 * @param name
	 * @param dept
	 * @param phoneNumber
	 * @param startDate
	 * @param noOfStaff
	 * @param salary
	 * @param bonus
	 */
	public Manager(Name name, Department dept, String phoneNumber, Date startDate, int noOfStaff, double salary,
			double bonus) {
		super(name, dept, phoneNumber, startDate);
		this.noOfStaff = noOfStaff;
		this.salary = salary;
		this.bonus = bonus;
	}

	/**
	 * @return the noOfStaff
	 */
	public int getNoOfStaff() {
		return noOfStaff;
	}

	/**
	 * @param noOfStaff the noOfStaff to set
	 */
	public void setNoOfStaff(int noOfStaff) {
		this.noOfStaff = noOfStaff;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the bonus
	 */
	public double getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\nNumber of Staff under Manager: " + noOfStaff + "\nSalary: " + salary + "\nBonus: "
				+ bonus + "\n";
	}

	/**
	 * equals method, checks id, name and startDate match
	 */
	@Override
	public boolean equals(Object temp) {

		if (temp == null) {
			return false;
		}

		if (temp instanceof Manager) {

			Manager man = (Manager) temp;

			if (this.getId() == man.getId() && this.getName().equals(man.getName())
					&& this.getStartDate() == (man.getStartDate())) {

				// If all variables match we return to say that the two
				// objects are the same
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

	/**
	 * Method to calculate monthly pay for a manager
	 */
	public void monthlyPay(Employee temp) {
		Manager man = (Manager)temp;
		PaymentMenu pay = new PaymentMenu();
		@SuppressWarnings("resource")
		Scanner kIn = new Scanner(System.in);
		double month = 0;
		double week = 0;
		/*
		 * Calls devWeeklyPay method on loop 4 times, to get the weekly pay for 4 weeks.
		 * month stores the weekly value then adds next weekly value each loop
		 */
		for (int i = 1; i < 5; i++) {
			System.out.println("Please enter amount of hours worked for week " + i + " :");
			week = kIn.nextInt();
			week = pay.managerWeeklyPay(man, week);
			month += week;
		}
		System.out.printf("Monthly Salary: %.2f", month);
		temp.setMonthlyPay(month);
	}

	/**
	 * Method to change department for a manager
	 * 
	 * @param temp Employee object
	 */
	public void departmentChange(Employee temp) {

		@SuppressWarnings("resource")
		Scanner keyIn = new Scanner(System.in);
		boolean approved = false;
		int noOfManagers = 0;
		int deptID = 0;
		DeptStorage deptStore = new DeptStorage();
		Department depts = temp.getDept();
		ArrayList<Department> departments = deptStore.getDepartments();

		do {
			System.out.println("Please enter Dept ID of department you wish to transfer " + "to (1, 2, 3 or 4):");
			deptID = keyIn.nextInt();
		} while (deptID < 1 || deptID > 4);

		Storage store = new Storage();
		ArrayList<Employee> employees = store.getEmployees();
		/*
		 * Searching employees ArrayList for instances of Manager that are in the
		 * selected department. Increments noOfManagers when found
		 */
		for (Employee employee : employees) {
			if (employee instanceof Manager) {
				Department dept = employee.getDept();
				if (dept.getDeptID() == deptID) {
					noOfManagers++;
				}
			}
		}
		/*
		 * Searches through departments ArrayList, if matches AND managers < 2,
		 * approved.
		 */
		for (Department department : departments) {
			if (deptID == department.getDeptID() && noOfManagers < 2) {
				temp.setDept(department);
				depts.setNoOfEmployees(depts.getNoOfEmployees() - 1);
				department.setNoOfEmployees(department.getNoOfEmployees() + 1);
				System.out.println("Department transfer request approved.");
				approved = true;
				break;
			}
		}
		if (!approved) {
			System.out.println("Department transfer request denied due to too many managers in target department.");
		}
	}

	/**
	 * Method to book a holiday for a manager, adds to holidays ArrayList,
	 * 
	 * @param obj Holiday Object
	 */
	public void bookHoliday(Holiday obj) {
		MainMenu main = new MainMenu();
		HolidayStorage holStore = new HolidayStorage();
		System.out.println("Holiday booking approved.");
		holStore.addNewHoliday(obj);
		main.showMenu();
	}
}
