package menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import file_handling.Storage;
import model.Developer;
import model.Employee;
import model.Manager;

public class EditEmployeeMenu {
	private Storage store = new Storage();
	private Scanner keyIn = new Scanner(System.in);
	private Scanner kIn = new Scanner(System.in);
	private DeptChangeMenu deptMenu = new DeptChangeMenu();

	/**
	 * Method to search employee and show appropriate menu
	 */

	public void showEmployeeMenu() {

		Employee temp = store.searchEmployee();

		if (temp instanceof Manager) {
			managerChange((Manager) temp);
		} else if (temp instanceof Developer) {
			developerChange((Developer) temp);
		}
	}

	/**
	 * Method to display menu for editing a manager
	 */

	public void managerChange(Manager temp) {
		System.out.println("***Edit Employee Menu***\nPlease select an option." + "\n1. Edit managers Salary"
				+ "\n2. Edit Managers bonus" + "\n3. Edit employees phone number" + "\n4. Request Department Change"
				+ "\n5. Exit");

		int choice = 0;
		choice = keyIn.nextInt();
		try {
			switch (choice) {
			case 1:
				System.out.println("Please enter managers new salary: ");
				double salary = keyIn.nextDouble();
				temp.setSalary(salary);
				break;
			case 2:
				System.out.println("Please enter managers new bonus: ");
				double bonus = keyIn.nextDouble();
				temp.setBonus(bonus);
				break;
			case 3:
				System.out.println("Please enter employees new phone number: ");
				String phNo = kIn.nextLine();
				temp.setPhoneNumber(phNo);
				break;
			case 4:
				deptMenu.deptChangeMenu(temp);
				break;
			case 5:
				System.out.println("Exiting");
				break;
			default:
				System.out.println("Invalid selection");
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid selection.");
			showEmployeeMenu();
		}
		store.saveEmployeeDetails();
	}

	/**
	 * Method to display menu for editing a developer
	 */
	public void developerChange(Developer temp) {
		System.out.println("***Edit Employee Menu***\nPlease select an option." + "\n1. Edit developers level"
				+ "\n2. Edit employees phone number" + "\n3. Request Department Change " + "\n4. Exit");

		int choice = 0;
		choice = keyIn.nextInt();
		try {
			switch (choice) {
			case 1:
				System.out.println("Please enter developers new level: ");
				int level = keyIn.nextInt();
				temp.setLevel(level);
				break;
			case 2:
				System.out.println("Please enter employees new phone number: ");
				String phNo = kIn.nextLine();
				temp.setPhoneNumber(phNo);
				break;
			case 3:
				deptMenu.deptChangeMenu(temp);
				break;
			case 4:
				System.out.println("Exiting");
				break;
			default:
				System.out.println("Invalid selection");
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid selection.");
			showEmployeeMenu();
		}
		store.saveEmployeeDetails();
	}
}
