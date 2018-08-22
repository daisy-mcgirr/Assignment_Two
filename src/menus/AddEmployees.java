
package menus;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.Department;
import model.Developer;
import model.Employee;
import model.Manager;
import model.Name;
import file_handling.DeptStorage;
import file_handling.Storage;

public class AddEmployees {
	private Scanner kIn = new Scanner(System.in);
	private Scanner keyIn = new Scanner(System.in);
	private Storage myStorage = new Storage();
	private DeptStorage deptStorage = new DeptStorage();

	/**
	 * Switch case / menu to add an employee, calls addManager() and addDeveloper()
	 * (Both call employee())
	 */
	public void addEmployee() {
		int choice;
		System.out.println("***Add Employee*** \n1. Add Manager \n2. Add Developer \n3. Exit");
		choice = keyIn.nextInt();
		switch (choice) {
		case 1:
			addManager();
			break;
		case 2:
			addDeveloper();
			break;
		case 3:
			System.out.println("Exiting...");
			break;
		default:
			System.out.println("Invalid selection. Please select 1. Manager or 2. Developer");
			addEmployee();
			break;
		}
	}

	/**
	 * Method to add a manager object
	 */
	public void addManager() {

		Manager temp = new Manager();
		// Calls employee method and sets temp object as new Developer object
		employee(temp);

		// Asks for noOfStaff manager will manage, sets noOfStaff
		System.out.println("Please enter number of staff new manager will manage: ");
		int staff = keyIn.nextInt();
		temp.setNoOfStaff(staff);

		// Asks for managers salary and sets salary
		System.out.println("Please enter new managers salary: ");
		double salary = keyIn.nextDouble();
		temp.setSalary(salary);

		// Asks for managers bonus and sets bonus
		System.out.println("Please enter new managers bonus: ");
		double bonus = keyIn.nextDouble();
		temp.setBonus(bonus);

		// adds employee to employees ArrayList
		myStorage.addNewEmployee(temp);
		System.out.println("New Manager Added.");
		
	}

	/**
	 * Method to add a developer object
	 */
	public void addDeveloper() {

		Developer temp = new Developer();
		// Calls employee method and sets temp object as new Developer object
		employee(temp);
		int level = 0;
		// Asks for developer level and sets level
		do {
			System.out.println("Please enter developers level (1, 2 or 3): ");
			level = keyIn.nextInt();
		} while (level < 1 || level > 3);
		temp.setLevel(level);
		// adds employee to employees ArrayList
		myStorage.addNewEmployee(temp);
		System.out.println("New Developer Added.");
	}

	/**
	 * Method to add an employee object, superclass variables only
	 */
	public Employee employee(Employee temp) {
		// Asks for Title, firstname, surname then sets new Name for temp
		System.out.println("Please enter title:");
		String title = kIn.next();
		System.out.println("Please enter First name:");
		String fName = kIn.next();
		System.out.println("Please enter Surname:");
		String sName = kIn.next();
		temp.setName(new Name(title, fName, sName));

		// Asks for deptID, searches ArrayList depts (departments), when department
		// found, sets department of object temp
		// and increments noOfStaff of chosen dept by 1
		int deptID = 0;
		do {
			System.out.println("Please enter Dept ID (1, 2, 3 or 4):");
			deptID = keyIn.nextInt();
		} while (deptID < 1 || deptID > 4);
		ArrayList<Department> departments = deptStorage.getDepartments();
		for (Department department : departments) {
			if (deptID == department.getDeptID()) {
				temp.setDept(department);
				// set number of employees to current number plus 1
				department.setNoOfEmployees(department.getNoOfEmployees() + 1);
				deptStorage.saveDepartmentDetails();
				break;
			}
		}
		// Asks for phone number, then sets temp object phone number
		System.out.println("Please enter phone number:");
		String phNo = kIn.next();
		temp.setPhoneNumber(phNo);

		// Asks for start date, then sets temp object sDate
		System.out.println("Please enter start date: ");
		System.out.println("Day:");
		int date = keyIn.nextInt();
		System.out.println("Month:");
		int month = keyIn.nextInt();
		System.out.println("Year:");
		int year = keyIn.nextInt();
		@SuppressWarnings("deprecation")
		Date sDate = new Date(year, month, date);
		temp.setStartDate(sDate);
		return temp;
	}
}
