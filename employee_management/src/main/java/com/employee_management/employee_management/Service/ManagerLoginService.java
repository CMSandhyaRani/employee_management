package com.employee_management.employee_management.Service;

import com.employee_management.employee_management.Entities.ManagerLogin;

public interface ManagerLoginService {
String signup(ManagerLogin managerLogin);
	
	String login(String email, String password);
}
