package com.employee_management.employee_management.Service;

import com.employee_management.employee_management.Entities.EmployeeLogin;

public interface EmployeeLoginService {
	String signup(EmployeeLogin employeeLogin);
	
	String login(String email, String password);
}
