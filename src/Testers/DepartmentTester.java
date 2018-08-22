package Testers;

import java.util.ArrayList;

import model.Department;

public class DepartmentTester {

	public static void main(String[] args) {
		// Set undefined Department object
		Department departmentOne = new Department();

		// Set defined Department object with all the correct details
		Department departmentTwo = new Department(2, "Human Resources", 6);
		Department departmentThree = new Department(3, "Global Tech", 15);
		Department departmentFour = new Department(4, "Dossers", 13);
		Department departmentFive = new Department(1, "Maintenance", 6);

		// Test our setters by initializing the variables
		// setting first Department object
		departmentOne.setDeptID(1);
		departmentOne.setDeptName("Maintenance");
		departmentOne.setNoOfEmployees(6);

		// Test the toString method and the getter methods
		System.out.println(departmentOne);
		System.out.println(departmentTwo.getDeptID());
		System.out.println(departmentThree.getNoOfEmployees());
		System.out.println(departmentFour + "\n");

		/*
		 * Now create an if statement where we can check if the two Departments are the
		 * same. We should always test for failure so we will pass in two Name objects
		 * we know are not the same. Then we pass two objects we know are the same.
		 */
		
		if (departmentTwo.equals(departmentThree)) {
			System.out.println("These departments are the same\n");
		} else {
			System.out.println("These departments are different\n");
		}

		if (departmentOne.equals(departmentFive)) {
			System.out.println("These departments are the same\n");
		} else {
			System.out.println("These departments are different\n");
		}

		ArrayList<Department> departments = new ArrayList<>();
		departments.add(departmentOne);
		departments.add(departmentTwo);
		departments.add(departmentThree);
		departments.add(departmentFour);
		departments.add(departmentFive);

		for (Department d : departments) {
			System.out.println(d);
		}

	}

}
