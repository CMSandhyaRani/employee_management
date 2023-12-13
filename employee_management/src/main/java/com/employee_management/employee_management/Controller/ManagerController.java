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
import com.employee_management.employee_management.Entities.Manager;
import com.employee_management.employee_management.Service.ManagerService;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {
  @Autowired
  ManagerService managerService;
  @PostMapping("/create")
  public Manager createManager(@RequestBody Manager manager) 
  {
  	return managerService.createManager(manager);
  }

  @GetMapping("/show")
  public List<Manager> getAll()
  {
  	return managerService.getAll();
  }

  @GetMapping("/find/{id}")
  public Manager findById(@PathVariable Long id) {
  	return managerService.findManagerById( id);
  }

  @PutMapping("/update/{id}")
  public Manager updateManager(@PathVariable Long id, @RequestBody Manager manager)
  {
  	return managerService.updateManager(id, manager);
  }

  @DeleteMapping("/delete/{id}")
  public String deleteManager(@PathVariable Long id) {
  	return managerService.deleteManager(id);
  }

 @GetMapping("/find-employee-under-manager/{id}")
 public List<Employee> findEmployeeunderManager(@PathVariable Long id){
	 return managerService.findEmployeeunderManager(id);
 }
  
  @PostMapping("/assign/{manid}")
  public String assignment(@RequestBody List<Long> empid,@PathVariable Long manid) {
	  return managerService.assignment(empid, manid);
  }
}
