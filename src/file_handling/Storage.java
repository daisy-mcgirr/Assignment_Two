package file_handling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import menus.MainMenu;
import model.Department;
import model.Developer;
import model.Employee;
import model.Manager;

public class Storage implements Serializable {

	private static final long serialVersionUID = 1L;
	private File employeeFile = new File("employees_list.bin");

	private static ArrayList<Employee> employees = new ArrayList<>();

	/**
	 * adds new employee object to employees list
	 * 
	 * @param temp
	 */
	public void addNewEmployee(Employee temp) {
		employees.add(temp);
		// saving employees list to file
		saveEmployeeDetails();
		DeptStorage department = new DeptStorage();
		department.saveDepartmentDetails();

	}

	/**
	 * Method to return ArrayList employees
	 * 
	 * @return employees
	 */
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	/**
	 * Reads in list of employees from file, populates employees ArrayList
	 */
	@SuppressWarnings("unchecked")
	public void readEmployeeDetails() {
		/*
		 * If employeeFile has been created, it reads the objects and populates
		 * employees ArrayList
		 */
		if (employeeFile.exists()) {

			try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(employeeFile))) {

				employees = (ArrayList<Employee>) inStream.readObject();

				updateIdNumber();
			} catch (IOException | ClassNotFoundException e) {
				System.out.println(
						"File not found. Please continue and file will be automatically generated when a new employee is created.");
			}
		}
		// If employeeFile does not exist, creates new employeeFile
		else {
			try {
				employeeFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Saves ArrayList employees to file
	 */
	public void saveEmployeeDetails() {

		try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(employeeFile))) {

			outStream.writeObject(employees);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * updates Id number
	 */
	public void updateIdNumber() {

		int largest = 0;
		if (employees != null) {
			for (Employee emp : employees) {

				if (emp.getId() > largest) {
					largest = emp.getId();
				}
			}

			Employee.setNextIdNumber(largest + 1);
		}
	}

	/**
	 * Loops though employees ArrayList and prints on screen
	 */
	public void listAllEmployees() {
		for (Employee emp : employees) {
			System.out.println(emp.toString());
		}
	}

	/**
	 * Loops though employees ArrayList and prints any instaceof Manager on screen
	 */
	public void viewAllManagers() {
		for (Employee emp : employees) {
			if (emp instanceof Manager) {
				System.out.println(emp);
			}
		}
	}

	/**
	 * Loops though employees ArrayList and prints any instaceof Developer on screen
	 */
	public void viewAllDevelopers() {
		for (Employee emp : employees) {
			if (emp instanceof Developer) {
				System.out.println(emp);
			}
		}
	}

	/**
	 * Method searches for employee, asks for ID number, matches employee object and
	 * returns true if found
	 * 
	 * @return e
	 */
	public Employee searchEmployee() {
		@SuppressWarnings("resource")
		Scanner kIn = new Scanner(System.in);
		try {
			System.out.println("Please enter employee ID: ");
			int id = kIn.nextInt();
			boolean employeeFound = false;
			for (Employee emp : employees) {
				if (id == emp.getId()) {
					System.out.println(emp.toString());
					employeeFound = true;
					return emp;
				}
			}
			// If employee object is not found, returns to searchEmployee start
			if (!employeeFound) {
				System.out.println("Cannot find employee with entered ID.");
				searchEmployee();
			}
		} catch (InputMismatchException e) {
			System.out.println("Please enter a numerical value only");
			searchEmployee();
		}
		return null;
	}

	/**
	 * Method to delete and employee
	 * 
	 */
	public void deleteEmployee() {
		@SuppressWarnings("resource")
		Scanner keyIn = new Scanner(System.in);
		DeptStorage deptStorage = new DeptStorage();
		char option = 'a';
		try {
			// Searches for employee by ID using searchEmployee method and prints to screen
			Employee temp = searchEmployee();
			ArrayList<Department> depts = deptStorage.getDepartments();
			Department dept = temp.getDept();

			System.out.println("Are you sure you want to remove this Employee? (Y/N)");
			option = keyIn.next().charAt(0);
			/*
			 * if option selected is Y, search deptID against object deptID. If equals is
			 * true, set number of employee by getting number of employees then decrement by
			 * 1
			 */
			if (option == 'Y' || option == 'y') {
				for (Department department : depts) {
					if (dept.getDeptID() == department.getDeptID());
					dept.setNoOfEmployees(dept.getNoOfEmployees() - 1);
					break;
				}
				// remove employee, then save employees ArrayList
				employees.remove(temp);
				System.out.println("Employee removed.");
				saveEmployeeDetails();
				// If option n is selected, goes back to main menu
			} else if (option == 'N' || option == 'n') {
				System.out.println("Employee not removed.");
				MainMenu main = new MainMenu();
				main.showMenu();
			}
		} catch (NullPointerException e) {
		}
	}
}
