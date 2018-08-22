package menus;

import java.util.Date;
import java.util.Scanner;

import file_handling.HolidayStorage;
import file_handling.Storage;
import model.Developer;
import model.Employee;
import model.Holiday;
import model.Manager;

public class HolidayMenu {

	private Scanner keyIn = new Scanner(System.in);
	private Storage store = new Storage();

	/**
	 * Method to display menu for viewing / booking holidays
	 */
	public void mainHolidayMenu() {
		int choice = 0;

		System.out.println("***Holiday Menu Options***" + "\nPlease select one of the following: "
				+ "\n1. View all holiday bookings" + "\n2. Request holiday booking" + "\n3. Exit");
		choice = keyIn.nextInt();
		do {
			switch (choice) {
			case 1:
				HolidayStorage holStore = new HolidayStorage();
				holStore.viewHolidays();
				break;
			case 2:
				holidayBookingRequest();
				break;
			case 3:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid selection.");
				mainHolidayMenu();
				break;
			}
		} while (choice != 3);
	}

	/**
	 * Method to request a holiday booking, requests employee ID, start date and end
	 * date.
	 */
	public void holidayBookingRequest() {

		System.out.println("***Holiday booking request***");
		Holiday hols = new Holiday();

		Employee temp = store.searchEmployee();
		hols.setEmployee(temp);

		System.out.println("Please enter start date: ");
		Date sDate = setDate();
		hols.setStartDate(sDate);

		System.out.println("Please enter end date: ");
		Date eDate = setDate();
		hols.setEndDate(eDate);
		// (Take start date from end date) / (calculate from milliseconds to days).
		// Check are the number of days greater than 14, if true, print
		if (((eDate.getTime() - sDate.getTime()) / (1000 * 60 * 60 * 24)) > 14) {
			System.out.println("Holiday bookings cannot exceed 14 days.");
		}
		// If number of days are less than 14, calls appropriate method for Employee
		// type to request holiday.
		else {
			if (temp instanceof Manager) {
				Manager man = (Manager) temp;
				man.bookHoliday(hols);
			} else {
				Developer dev = (Developer) temp;
				dev.bookHoliday(hols);
			}
		}
	}

	/**
	 * Method to set the date return sDate
	 */
	public Date setDate() {
		System.out.println("Day:");
		int date = keyIn.nextInt();
		System.out.println("Month:");
		int month = keyIn.nextInt();
		System.out.println("Year:");
		int year = keyIn.nextInt();
		@SuppressWarnings("deprecation")
		Date sDate = new Date(year, month, date);
		return sDate;
	}
}
