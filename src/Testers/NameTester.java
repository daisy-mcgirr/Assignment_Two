package Testers;

import java.util.ArrayList;

import model.Name;

public class NameTester {

	public static void main(String[] args) {

		// Set undefined Name object
		Name nameOne = new Name();

		// Set defined Name object with all the correct details
		Name nameTwo = new Name("Mrs", "Santa", "Helena");
		Name nameThree = new Name("Mr", "Jack", "Daniels");
		Name nameFour = new Name("Miss", "Daisy", "Duck");
		Name nameFive = new Name("Mr", "Benson", "Hedges");

		// Test our setters by initializing the variables
		// setting first Name object
		nameOne.setTitle("Mr");
		nameOne.setFirstName("Benson");
		nameOne.setLastName("Hedges");

		// Test the toString method and the getter methods
		System.out.println(nameOne);
		System.out.println(nameTwo.getTitle());
		System.out.println(nameThree.getFirstName());
		System.out.println(nameFour.getLastName());
		System.out.println(nameFive + "\n");

		// Testing the equals method
		if (nameTwo.equals(nameThree)) {
			System.out.println("These names are the same\n");
		} else {
			System.out.println("These names are different\n");
		}

		if (nameOne.equals(nameFive)) {
			System.out.println("These names are the same\n");
		} else {
			System.out.println("These names are different\n");
		}

		ArrayList<Name> names = new ArrayList<>();
		names.add(nameOne);
		names.add(nameTwo);
		names.add(nameThree);
		names.add(nameFour);
		names.add(nameFive);

		for (Name n : names) {
			System.out.println(n);
		}
	}
}
