package menus;

import file_handling.Storage;
import model.Developer;
import model.Employee;
import model.Manager;

public class PaymentMenu {
	/**
	 * Method to display menu for payments
	 */
	public void paymentMenus() {
		Storage store = new Storage();
		System.out.println("***Payment Menu***");
		Employee temp = store.searchEmployee();

		if (temp instanceof Manager) {
			Manager man = (Manager) temp;
			man.monthlyPay(temp);
		} else {
			Developer dev = (Developer) temp;
			dev.monthlyPay(temp);
		}
	}

	/**
	 * Method to calculate the developers weekly pay
	 */
	public double devWeeklyPay(Developer temp, double hoursWorked) {
		double hourlyPay = temp.getHourlyRate();
		double overTimeHours;
		double weeklyPay = 0;
		double overTimeRate = hourlyPay * 1.5;

		if (hoursWorked > 35) {
			weeklyPay = hourlyPay * 35;
			overTimeHours = hoursWorked - 35;
			overTimeHours = overTimeHours * overTimeRate;
			weeklyPay = weeklyPay + overTimeHours;
		} else {
			weeklyPay = hoursWorked * hourlyPay;
		}
		return weeklyPay;
	}

	/**
	 * Method to calculate managers weekly pay
	 */
	public double managerWeeklyPay(Manager temp, double hoursWorked) {
		double salary = temp.getSalary();
		double bonus = temp.getBonus();
		double monthlySalary = (salary * bonus) + salary;
		double weeklyPay = monthlySalary / 4;
		double hourlyPay = weeklyPay / 35;

		if (hoursWorked > 35) {
			return weeklyPay;
		} else {
			weeklyPay = hourlyPay * hoursWorked;
		}
		return weeklyPay;
	}

}
