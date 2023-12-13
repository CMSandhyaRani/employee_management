package com.employee_management.employee_management.Service;

import java.util.List;

import com.employee_management.employee_management.Entities.Employee;

public interface EmployeeService {
	//STEP 1 CREATING
	Employee createEmployee(Employee employee);
		
	//STEP 2 FETCHING
	List<Employee>getAll();

	//STEP 3 FOR FINDING ROW ON THE BASIS OF ID

	Employee findEmployeeById(Long id);

	//STEP 4 FOR UPDATING ROW ON THE BASIS OF ID

	Employee updateEmployee(Long id,Employee employee);
		
	//STEP 5 FOR DELETING ROW ON THE BASIS OF ID
	String deleteEmployee(Long id);

	String assignManagerToEmployee(Long manag_id, Long emp_id);
	
	
	
}
