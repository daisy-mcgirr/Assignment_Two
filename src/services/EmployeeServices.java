package services;

import model.Employee;
import model.Holiday;

public interface EmployeeServices {

	void monthlyPay(Employee temp);
	
	void departmentChange (Employee temp);
	
	void bookHoliday (Holiday hols);
}
