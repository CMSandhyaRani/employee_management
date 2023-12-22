 package com.employee_management.employee_management.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_management.employee_management.Entities.Employee;
import com.employee_management.employee_management.Entities.Manager;
import com.employee_management.employee_management.Repositories.Employee_ManagementRepository;
import com.employee_management.employee_management.Repositories.ManagerReposiory;
import com.employee_management.employee_management.Service.ManagerService;

import Exceptions.EmployeeException;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerReposiory managerReposiory;
	@Autowired
	Employee_ManagementRepository employeeRepository;
	@Override
	public Manager createManager(Manager manager) {
		
		return managerReposiory.save(manager);
	}

	@Override
	public List<Manager> getAll() {
		
		return managerReposiory.findAll();
	}

	@Override
	public Manager findManagerById(Long id) {
		
		return managerReposiory.findById(id).get();
	}

	@Override
	public Manager updateManager(Long id, Manager manager) {
		Manager m=managerReposiory.findById(id).get();
		m.setName(manager.getName());
		m.setAddress(manager.getAddress());
		m.setDepartment(manager.getDepartment());
		return managerReposiory.save(m);
		
	}

	@Override
	public String deleteManager(Long id) {
		managerReposiory.deleteById(id);
		return "Your Record has been deleted";
	}

	@Override
	public String assignment(List<Long> empid,Long manid ) {
		// TODO Auto-generated method stub
		Manager manager = managerReposiory.findById(manid).get();
		List<Employee> employees = new ArrayList<>();
		//Employee e ;
		for(Long i : empid)
		{
			
			
			try
			{
				employees.add(employeeRepository.findById(i).get());
			//Employee e = null;)
			}
			catch(NoSuchElementException exe) {
				return "Employee Id :" + i+" doesn't exist";
			}
			
			
			
		}
		System.out.println(employees);
		
		for(Employee i : employees)
		{
			/*try {
				if(i.getFirst_name().equals(null))
				{
					System.out.println("Hello");
					throw new EmployeeException("This Employee Id does't exist");
				}
			}
			catch(EmployeeException e) {
				return e.getMessage();
			}*/
		i.setManager(manager);
		employeeRepository.save(i);
		}
		
		return "Manager is assigned";
	}

	@Override
	public List<Employee> findEmployeeunderManager(Long id) {
		Manager manager = managerReposiory.findById(id).get();
		List<Employee>employee = manager.getEmployee();
		return employee;
		
	}

/*	@Override
	public List<Employee> findEmployeeunderManager(Long id) {
		Manager manager = managerReposiory.findById(id).get();
		List<Employee>employee = manager.getEmployee();
		return employee;
	}*/
	
	

	
}
