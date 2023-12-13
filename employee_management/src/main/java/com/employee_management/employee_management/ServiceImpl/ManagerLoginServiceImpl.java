package com.employee_management.employee_management.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_management.employee_management.Entities.ManagerLogin;
import com.employee_management.employee_management.Repositories.ManagerLoginRepository;
import com.employee_management.employee_management.Service.ManagerLoginService;

@Service
public class ManagerLoginServiceImpl implements ManagerLoginService{

	@Autowired
	ManagerLoginRepository managerLoginRepository;
	@Override
	public String signup(ManagerLogin managerLogin) {
		managerLoginRepository.save(managerLogin);
		return "Account Has been created";
	}

	@Override
	public String login(String email, String password) {
		ManagerLogin managerLogin=managerLoginRepository.findbyemailid(email);
		if(managerLogin!=null)
		{
			if(managerLogin.getPassword().equals(password))
		return "you are welcome";
				
				return "Invalid password";
		}
		else
			return "kindly create account";
	}
	}


