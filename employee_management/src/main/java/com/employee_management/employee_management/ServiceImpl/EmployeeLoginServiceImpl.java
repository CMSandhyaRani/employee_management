package com.employee_management.employee_management.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_management.employee_management.Entities.EmployeeLogin;

import com.employee_management.employee_management.Repositories.EmployeeLoginRepository;
import com.employee_management.employee_management.Service.EmployeeLoginService;

@Service
public class EmployeeLoginServiceImpl implements EmployeeLoginService{
	@Autowired
	EmployeeLoginRepository employeeLoginRepository;

	@Override
	public String signup(EmployeeLogin employeeLogin) {
		employeeLoginRepository.save(employeeLogin);
		return "Account Has been created";
	}

	@Override
	public String login(String email,String password) {
		EmployeeLogin employeeLogin=employeeLoginRepository.findbyemailid(email);
		if(employeeLogin!=null)
		{
			if(employeeLogin.getPassword().equals(password))
		return "you are welcome";
				
				return "Invalid password";
		}
		else
			return "kindly create account";
	}
	}
	
	


