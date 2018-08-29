package junit_tests;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import file_handling.Storage;
import model.Department;
import model.Manager;
import model.Name;

class StorageTests {
	
	Storage myStorage = new Storage();

	@Test
	public void AddNewEmployeeTest() {
		
		Manager temp = new Manager((new Name("Mr", "Potty", "Potts")), (new Department(1, "HR", 3)), "05888888",
				new Date(), 5, 3456.00, 0.05);

		myStorage.addNewEmployee(temp);

		assertEquals(1, myStorage.getEmployees().size());
	}

}