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

import model.Department;

public class DeptStorage implements Serializable {

	private static final long serialVersionUID = 1L;
	private File departmentFile = new File("department_list.bin");
	private static ArrayList<Department> depts = new ArrayList<>();

	/**
	 * Method to read in department details from file, populates ArrayList depts
	 */
	@SuppressWarnings("unchecked")
	public void readDepartmentDetails() {
		/*
		 * If departmentFile has been created, it reads the objects and populates depts
		 * ArrayList
		 */
		if (departmentFile.exists()) {

			try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(departmentFile))) {

				depts = (ArrayList<Department>) inStream.readObject();

			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		// If departmentFile does not exist, creates new departmentFile
		else {
			try {
				departmentFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method to save the departments to file.
	 **/
	public void saveDepartmentDetails() {

		try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(departmentFile))) {

			outStream.writeObject(depts);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to load the departments to array list on first run, no longer needed
	 * to load each time after.
	 **/
	public void loadDepts() {
		// Creates 4 departments and adds them to depts ArrayList
		Department departmentOne = new Department(1, "Maintenance", 0);
		Department departmentTwo = new Department(2, "Human Resources", 0);
		Department departmentThree = new Department(3, "Global Tech", 0);
		Department departmentFour = new Department(4, "Dossers", 0);

		depts.add(departmentOne);
		depts.add(departmentTwo);
		depts.add(departmentThree);
		depts.add(departmentFour);

	}

	/**
	 * Method to return ArrayList depts
	 * 
	 * @return depts
	 */
	public ArrayList<Department> getDepartments() {
		return depts;
	}

	/**
	 * Method searches for noOfStaff in a department, asks for deptID number,
	 * matches department object and prints noOfStaff in requested department
	 */
	public void searchStaffInDepartment() {
		@SuppressWarnings("resource")
		Scanner kIn = new Scanner(System.in);
		int id = 0;
		try {
			do {
				System.out.println("Please enter department ID (1, 2, 3 or 4): ");
				id = kIn.nextInt();
			} while (id < 1 || id > 4);
			boolean departmentFound = false;
			for (Department dept : depts) {
				if (id == dept.getDeptID()) {
					System.out.println("Number of staff in Department: " + dept.getNoOfEmployees());
					departmentFound = true;
					break;
				}
			}
			if (!departmentFound) {
				System.out.println("Cannot find department with entered ID.");
				searchStaffInDepartment();
			}
		} catch (InputMismatchException e) {
			System.out.println("Please enter a numerical value only");
			searchStaffInDepartment();
		}
	}
}
