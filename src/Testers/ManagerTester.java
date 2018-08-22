package Testers;

import java.util.ArrayList;
import java.util.Date;

import model.Department;
import model.Manager;
import model.Name;

public class ManagerTester {

	public static void main(String[] args) {
		Manager manOne = new Manager((new Name("Mr", "Potty", "Potts")), (new Department(1, "HR", 3)), "05888888",
				new Date(), 5, 3456.00, 0.05);

		System.out.println(manOne.getId());
		System.out.println(manOne.getName());
		System.out.println(manOne.getDept());
		System.out.println(manOne.getPhoneNumber());
		System.out.println(manOne.getStartDate());
		System.out.println(manOne.getNoOfStaff());
		System.out.println(manOne.getSalary());
		System.out.println(manOne.getBonus());

		Manager manTwo = new Manager();
		manTwo.setName(new Name("Mr", "Harley", "Davidson"));
		manTwo.setDept(new Department(1, "DevOps", 4));
		manTwo.setPhoneNumber("999");
		manTwo.setStartDate(new Date());
		manTwo.setNoOfStaff(1);
		manTwo.setSalary(3456.34);
		manTwo.setBonus(0.025);
		System.out.println(manTwo);

		Manager manThree = new Manager((new Name("Mr", "Potty", "Potts")), (new Department(1, "HR", 3)), "05888888",
				new Date(), 5, 3456.00, 0.05);
		System.out.println(manThree);

		if (manOne.equals(manThree)) {
			System.out.println("Match");
		} else {
			System.out.println("Do not match");
		}
		if (manOne.equals(manOne)) {
			System.out.println("Match");
		} else {
			System.out.println("Do not match");
		}
		ArrayList<Manager> mans = new ArrayList<>();
		mans.add(manOne);
		mans.add(manTwo);

		for (Manager m : mans) {
			System.out.println(m);
		}
	}
}
