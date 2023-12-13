package com.employee_management.employee_management.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee_management.employee_management.Entities.EmployeeLogin;

public interface EmployeeLoginRepository extends JpaRepository<EmployeeLogin,Long>{

	@Query(value="select * from Employee_Login el where el.email like(:query)",nativeQuery=true)
	EmployeeLogin findbyemailid (String  query);
}
