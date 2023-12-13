package com.employee_management.employee_management.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee_management.employee_management.Entities.ManagerLogin;

public interface ManagerLoginRepository extends JpaRepository<ManagerLogin,Long>{
	@Query(value="select * from Manager_Login ml where ml.email like(:query)",nativeQuery=true)
	ManagerLogin findbyemailid (String  query);
}
