package main;

import file_handling.DeptStorage;
import file_handling.Storage;
import file_handling.HolidayStorage;
import menus.MainMenu;

public class StartUp {
	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		DeptStorage deptStorage = new DeptStorage();
		// reading department list from file
		deptStorage.readDepartmentDetails();

		HolidayStorage holStorage = new HolidayStorage();
		// reading booked holiday list from file
		holStorage.readHolidayDetails();

		Storage myStorage = new Storage();
		// reading employee list from file
		myStorage.readEmployeeDetails();

		MainMenu menus = new MainMenu();
		// calling showMenu method to display main menu
		menus.showMenu();
	}

}