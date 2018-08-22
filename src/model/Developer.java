package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import file_handling.DeptStorage;
import file_handling.HolidayStorage;
import menus.MainMenu;
import menus.PaymentMenu;
import services.EmployeeServices;

public class Developer extends Employee implements EmployeeServices {

	private static final long serialVersionUID = 1L;
	private int level;
	private double hourlyRate;

	/**
	 * Declare a default constructor as we also have a loaded one
	 */
	public Developer() {
		super();
		if (level == 1) {
			this.hourlyRate = 17.00;
		} else if (level == 2) {
			this.hourlyRate = 18.00;
		} else {
			this.hourlyRate = 19.50;
		}
	}

	/**
	 * @param name
	 * @param dept
	 * @param phoneNumber
	 * @param startDate
	 * @param level
	 */
	public Developer(Name name, Department dept, String phoneNumber, Date startDate, int level) {
		super(name, dept, phoneNumber, startDate);
		if (level == 1) {
			this.level = level;
			this.hourlyRate = 17.00;
		} else if (level == 2) {
			this.level = level;
			this.hourlyRate = 18.00;
		} else {
			this.level = level;
			this.hourlyRate = 19.50;
		}
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the hourlyRate
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * @param hourlyRate the hourlyRate to set
	 */
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\nDeveloper Level: " + level + "\nHourly Rate: " + hourlyRate;
	}

	/**
	 * equals method, checks id, name and startDate match
	 */
	@Override
	public boolean equals(Object temp) {

		if (temp == null) {
			return false;
		}

		if (temp instanceof Developer) {

			Developer dev = (Developer) temp;

			if (this.getId() == dev.getId() && this.getName().equals(dev.getName())
					&& this.getStartDate() == (dev.getStartDate())) {

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
	 * Method to calculate monthly pay for a developer
	 */
	public void monthlyPay(Employee temp) {
		Developer dev = (Developer)temp;
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
			week = pay.devWeeklyPay(dev, week);
			month += week;
		}
		System.out.printf("Your monthly pay: %.2f", month);
		temp.setMonthlyPay(month);
	}

	/**
	 * Method to change department for a developer
	 */
	public void departmentChange(Employee temp) {

		@SuppressWarnings("resource")
		Scanner keyIn = new Scanner(System.in);
		boolean approved = false;
		DeptStorage deptStore = new DeptStorage();
		Department dept = temp.getDept();
		int deptID = 0;
		/*
		 * Asks for department ID of chosen department, searches Arraylist of
		 * departments to match department of temp object. If matches AND less than 14,
		 * move approved
		 */
		do {
			System.out.println("Please enter Dept ID of department you wish to transfer to (1, 2, 3 or 4):");
			deptID = keyIn.nextInt();
		} while (deptID < 1 || deptID > 4);

		ArrayList<Department> departments = deptStore.getDepartments();

		for (Department department : departments) {
			if (deptID == department.getDeptID() && department.getNoOfEmployees() < 14) {
				temp.setDept(department);
				dept.setNoOfEmployees(dept.getNoOfEmployees() - 1);
				department.setNoOfEmployees(department.getNoOfEmployees() + 1);
				System.out.println("Department transfer request approved.");
				approved = true;
				break;
			}
		}
		if (!approved) {
			System.out.println("Department transfer request denied due to too many employees in target department.");
		}
	}

	/**
	 * Method to book a holiday for a developer
	 */
	public void bookHoliday(Holiday hols) {
		HolidayStorage holStore = new HolidayStorage();
		@SuppressWarnings("resource")
		Scanner keyIn = new Scanner(System.in);
		MainMenu main = new MainMenu();

		try {
			/*
			 * Asks for manager to input Y or N to approve or deny holiday Request.
			 */
			System.out.println("Manager approval required. Please select (Y/N)");
			char option = 'a';
			do {
				option = keyIn.next().charAt(0);
				if (option == 'Y' || option == 'y') {
					System.out.println("Holiday request approved.");
					holStore.addNewHoliday(hols);
					main.showMenu();
				} else if (option == 'N' || option == 'n') {
					System.out.println("Holiday request denied.");
					main.showMenu();
				} else {
					System.out.println("Please select Y/N only.");
				}
			} while (option != 'Y' || option != 'y' || option != 'N' || option != 'n');
		} catch (InputMismatchException e) {
			System.out.println("Please select Y/N");
		}
	}
}
