package com.employee_management.employee_management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_management.employee_management.Entities.Employee;
import com.employee_management.employee_management.Entities.Manager;
import com.employee_management.employee_management.Repositories.Employee_ManagementRepository;
import com.employee_management.employee_management.Repositories.ManagerReposiory;
import com.employee_management.employee_management.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	Employee_ManagementRepository employee_ManagementRepository;
	@Autowired
	ManagerReposiory managerReposiory;

	@Override
	public Employee createEmployee(Employee employee) {
		
		return employee_ManagementRepository.save(employee);
	}

	@Override
	public List<Employee> getAll() {
		return employee_ManagementRepository.findAll();
		 
	}

	@Override
	public Employee findEmployeeById(Long id) {
		
		return employee_ManagementRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee e=employee_ManagementRepository.findById(id).get();
		e.setFirst_name(employee.getFirst_name());
		e.setLast_name(employee.getLast_name());
		e.setDate_of_birth(employee.getDate_of_birth());
		e.setHire_date(employee.getHire_date());
		return employee_ManagementRepository.save(e);
		
	}

	@Override
	public String deleteEmployee(Long id) {
		employee_ManagementRepository.deleteById(id);
		return "Your Record has been deleted";
		
	}

	@Override
	public String assignManagerToEmployee(Long manag_id, Long emp_id) {
		Manager manager = managerReposiory.findById(manag_id).get();
		Employee e =employee_ManagementRepository.findById(emp_id).get();
		e.setManager(manager);
		employee_ManagementRepository.save(e);
		return "Manager is assigned";
	}

	

	

	
}
