package file_handling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import menus.MainMenu;
import model.Holiday;

public class HolidayStorage implements Serializable {

	private static final long serialVersionUID = 1L;
	private File holidayFile = new File("holiday_list.bin");
	private static ArrayList<Holiday> holidays = new ArrayList<>();

	/**
	 * adds new holiday object to array list
	 * 
	 * @param temp
	 */
	public void addNewHoliday(Holiday temp) {
		holidays.add(temp);
		// Saving holidays to file
		saveHolidayDetails();

	}

	/**
	 * View all booked holidays from holidays ArrayList
	 */
	public void viewHolidays() {
		MainMenu main = new MainMenu();
		for (Holiday hol : holidays) {
			System.out.println(hol);
		}
		// calling showMenu method to go back to main menu
		main.showMenu();
	}

	/**
	 * Reads in list of booked holidays from file, populates holidays ArrayList
	 */
	@SuppressWarnings("unchecked")
	public void readHolidayDetails() {
		// If holidayFile has been created, it reads the objects and populates holidays
		// ArrayList
		if (holidayFile.exists()) {

			try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(holidayFile))) {

				holidays = (ArrayList<Holiday>) inStream.readObject();

			} catch (IOException | ClassNotFoundException e) {
				System.out.println(
						"File not found. Please continue and file will be automatically generated when a holiday is booked.");
			}
			// If holidayFile does not exist, creates new holidayFile
		} else {
			try {
				holidayFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Saves ArrayList holidays to file
	 */
	public void saveHolidayDetails() {

		try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(holidayFile))) {

			outStream.writeObject(holidays);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
