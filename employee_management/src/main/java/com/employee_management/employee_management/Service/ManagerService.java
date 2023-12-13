package com.employee_management.employee_management.Service;

import java.util.List;

import com.employee_management.employee_management.Entities.Employee;
import com.employee_management.employee_management.Entities.Manager;

public interface ManagerService {
	//STEP 1 CREATING
	Manager createManager(Manager manager);
			
		//STEP 2 FETCHING
		List<Manager>getAll();

		//STEP 3 FOR FINDING ROW ON THE BASIS OF ID

		Manager findManagerById(Long id);

		//STEP 4 FOR UPDATING ROW ON THE BASIS OF ID

		Manager updateManager(Long id,Manager manager);
			
		//STEP 5 FOR DELETING ROW ON THE BASIS OF ID
		String deleteManager(Long id);
		
		List<Employee> findEmployeeunderManager(Long id);
		
		String assignment(List<Long> empid,Long manid );


}
