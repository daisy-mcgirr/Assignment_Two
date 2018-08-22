package Testers;

import java.util.ArrayList;
import java.util.Date;

import model.Department;
import model.Developer;
import model.Holiday;
import model.Name;

public class HolidayTester {

	public static void main(String[] args) {
		
		Developer devOne = new Developer((new Name ("Mr", "Potty", "Potts")), (new Department (1, "HR", 3)), "05888888", new Date(), 3);
		Developer devTwo = new Developer((new Name ("Mrs", "Sylvia", "Smith")), (new Department (2, "WR", 7)), "058866688", new Date(), 2);
		
		Holiday holiday = new Holiday(new Date(), new Date(), devOne);
		System.out.println(holiday);
		
		Holiday holidayOne = new Holiday();
		holidayOne.setStartDate(new Date());
		holidayOne.setEndDate(new Date());
		holidayOne.setEmployee(devTwo);
		
		holiday.getStartDate();
		holidayOne.getEndDate();
		holiday.getEmployee();
		
		ArrayList<Holiday> hols = new ArrayList<>();
		hols.add(holiday);
		hols.add(holidayOne);
		
		for(Holiday h : hols) {
			System.out.println(h);
		}
	}

}
