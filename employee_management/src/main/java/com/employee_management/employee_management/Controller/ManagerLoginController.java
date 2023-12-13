package com.employee_management.employee_management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee_management.employee_management.Entities.ManagerLogin;
import com.employee_management.employee_management.Service.ManagerLoginService;

@RestController
@RequestMapping("/api/managerlogin")
public class ManagerLoginController {
	@Autowired
	ManagerLoginService managerLoginService;
	@PostMapping("/signup")
	String signup(@RequestBody ManagerLogin managerLogin) {
		return managerLoginService.signup(managerLogin);
	}
	@GetMapping("/search/{email}/{password}")
	public ResponseEntity<String> login(@PathVariable String email, @PathVariable String password)
	{
		return ResponseEntity.ok(managerLoginService.login(email, password));
	}
}
