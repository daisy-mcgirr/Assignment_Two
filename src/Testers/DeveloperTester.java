package Testers;

import java.util.ArrayList;
import java.util.Date;

import model.Department;
import model.Developer;
import model.Name;

public class DeveloperTester {

	public static void main(String[] args) {
		Developer devOne = new Developer((new Name ("Mr", "Potty", "Potts")), (new Department (1, "HR", 3)), "05888888", new Date(), 3);
		System.out.println(devOne);
		
		System.out.println(devOne.getId());
		System.out.println(devOne.getName());
		System.out.println(devOne.getDept());
		System.out.println(devOne.getPhoneNumber());
		System.out.println(devOne.getStartDate());
		System.out.println(devOne.getLevel());
		
		Developer devTwo = new Developer();
		devTwo.setName(new Name ("Mr", "Harley", "Davidson"));
		devTwo.setDept(new Department (1, "DevOps", 4));
		devTwo.setPhoneNumber("999");
		devTwo.setStartDate(new Date());
		devTwo.setLevel(1);
		System.out.println(devTwo);
		
		Developer devThree = new Developer((new Name ("Mr", "Potty", "Potts")), (new Department (1, "HR", 3)), "05888888", new Date(), 3);
		System.out.println(devThree);
		
		if (devOne.equals(devThree)) {
			System.out.println("Match");
		}else {
			System.out.println("Do not match");
		}
		if (devOne.equals(devOne)) {
			System.out.println("Match");
		}else {
			System.out.println("Do not match");
		}
		ArrayList<Developer> devs = new ArrayList<>();
		devs.add(devOne);	
		devs.add(devTwo);
		
		for(Developer d : devs) {
			System.out.println(d);
		}
	}

}
