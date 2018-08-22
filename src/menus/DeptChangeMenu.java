package menus;

import file_handling.Storage;
import model.Developer;
import model.Employee;
import model.Manager;

public class DeptChangeMenu {
	/**
	 * Method to search ID and call appropriate departmentChange method
	 */
	public void deptChangeMenu(Employee temp) {

		Storage store = new Storage();
		System.out.println("***Department change request***");

		temp = store.searchEmployee();

		if (temp instanceof Manager) {
			Manager man = (Manager) temp;
			man.departmentChange(temp);
		} else {
			Developer dev = (Developer) temp;
			dev.departmentChange(temp);
		}
	}
}
