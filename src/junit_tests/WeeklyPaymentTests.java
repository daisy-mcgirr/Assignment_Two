package junit_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import menus.PaymentMenu;
import model.Department;
import model.Developer;
import model.Manager;
import model.Name;

class WeeklyPaymentTests {
	PaymentMenu pay = new PaymentMenu();

	@Test
	void testDevWeeklyPayLevel3() {

		Developer temp3 = new Developer(new Name("Mr", "John", "Jones"), (new Department(1, "Maint", 4)), "92391239",
				new Date(), 3);
		assertEquals(682.50, pay.devWeeklyPay(temp3, 35));
	}
	
	@Test
	void testDevWeeklyPayLevel3_Over35Hours() {

		Developer temp3 = new Developer(new Name("Mr", "John", "Jones"), (new Department(1, "Maint", 4)), "92391239",
				new Date(), 3);
		assertEquals(741.00, pay.devWeeklyPay(temp3, 37));
	}

	@Test
	void testDevWeeklyPayLevel2() {

		Developer temp4 = new Developer(new Name("Mr", "John", "Jones"), (new Department(1, "Maint", 4)), "92391239",
				new Date(), 2);
		assertEquals(630, pay.devWeeklyPay(temp4, 35));
	}
	
	@Test
	void testDevWeeklyPayLevel2_Over35Hours() {

		Developer temp3 = new Developer(new Name("Mr", "John", "Jones"), (new Department(1, "Maint", 4)), "92391239",
				new Date(), 2);
		assertEquals(684.00, pay.devWeeklyPay(temp3, 37));
	}

	@Test
	void testDevWeeklyPayLevel1() {

		Developer temp5 = new Developer(new Name("Mr", "John", "Jones"), (new Department(1, "Maint", 4)), "92391239",
				new Date(), 1);
		assertEquals(595, pay.devWeeklyPay(temp5, 35));
	}
	
	@Test
	void testDevWeeklyPayLevel1_Over35Hours() {

		Developer temp3 = new Developer(new Name("Mr", "John", "Jones"), (new Department(1, "Maint", 4)), "92391239",
				new Date(), 1);
		assertEquals(646, pay.devWeeklyPay(temp3, 37));
	}
	@Test
	void testManagerWeeklyPay35HoursAndBelow() {

		Manager temp = new Manager(new Name("Mrs", "Jane", "Doe"), (new Department(1, "HR", 4)), "9235656239",
				new Date(), 3, 2560.00, 0.02);
		assertEquals(615.49714285714285714285714285714, pay.managerWeeklyPay(temp, 33));
	}

	@Test
	void testManagerWeeklyPayOver35Hours() {
		Manager temp1 = new Manager(new Name("Mrs", "Jane", "Doe"), (new Department(1, "HR", 4)), "9235656239",
				new Date(), 3, 2560.00, 0.02);
		assertEquals(652.8, pay.managerWeeklyPay(temp1, 37));

	}

}
