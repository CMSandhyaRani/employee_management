package com.employee_management.employee_management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_management.employee_management.Entities.Employee;
import com.employee_management.employee_management.Service.EmployeeService;

@RestController
@RequestMapping("/api/employee")

public class EmployeeController {
@Autowired
EmployeeService employeeService;
@PostMapping("/create")
public Employee createEmployee(@RequestBody Employee employee) 
{
	return employeeService.createEmployee(employee);
}

@GetMapping("/show")
public List<Employee> getAll()
{
	return employeeService.getAll();
}

@GetMapping("/find/{id}")
public Employee findById(@PathVariable Long id) {
	return employeeService.findEmployeeById( id);
}

@PutMapping("/update/{id}")
public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee)
{
	return employeeService.updateEmployee(id, employee);
}

@DeleteMapping("/delete/{id}")
public String deleteEmployee(@PathVariable Long id) {
	return employeeService.deleteEmployee(id);
}

@PostMapping("/assign/{manag_id}/{emp_id}")
public String assignManagerToEmployee(@PathVariable Long manag_id, @PathVariable Long emp_id)
{
	return employeeService.assignManagerToEmployee(manag_id,emp_id);
}


}
