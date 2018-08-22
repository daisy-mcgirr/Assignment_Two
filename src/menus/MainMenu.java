package menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import file_handling.DeptStorage;
import file_handling.Help;
import file_handling.Storage;
import menus.AddEmployees;

public class MainMenu {

	/**
	 * Method to display main program menu, calls other sub menus.
	 */

	public void showMenu() {
		@SuppressWarnings("resource")
		Scanner kIn = new Scanner(System.in);
		Storage store = new Storage();
		DeptStorage deptStore = new DeptStorage();

		int choice = 0;
		try {
			do {
				System.out.println("\n***Main Menu***" + "\n1. List all Employees" + "\n2. Add a new Employee"
						+ "\n3. Edit an Employee" + "\n4. Delete an Employee" + "\n5. View all Managers"
						+ "\n6. View all Developers" + "\n7. View number of staff in Department"
						+ "\n8. Holiday Booking" + "\n9. Payments" + "\n10. Exit" + "\n0. On screen help"
						+ "\nPlease select an option: ");
				choice = kIn.nextInt();

				switch (choice) {
				case 1:
					store.listAllEmployees();
					break;
				case 2:
					AddEmployees add = new AddEmployees();
					add.addEmployee();
					break;
				case 3:
					EditEmployeeMenu editMenu = new EditEmployeeMenu();
					editMenu.showEmployeeMenu();
					break;
				case 4:
					store.deleteEmployee();
					break;
				case 5:
					store.viewAllManagers();
					break;
				case 6:
					store.viewAllDevelopers();
					break;
				case 7:
					deptStore.searchStaffInDepartment();
					break;
				case 8:
					HolidayMenu holMenu = new HolidayMenu();
					holMenu.mainHolidayMenu();
					break;
				case 9:
					PaymentMenu pay = new PaymentMenu();
					pay.paymentMenus();
					break;
				case 10:
					System.out.println("Exiting...");
					break;
				case 0:
					Help helpFile = new Help();
					helpFile.readHelpFile();
					break;
				default:
					System.out.println("Invalid option selected. Please choice from option 1 - 10.");
					break;
				}
			} while (choice != 10);
		} catch (InputMismatchException e) {
			System.out.println("Please enter a numerical value only.");
			showMenu();
		}
	}
}
