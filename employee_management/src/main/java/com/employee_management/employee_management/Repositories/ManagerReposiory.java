package com.employee_management.employee_management.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_management.employee_management.Entities.Manager;

public interface ManagerReposiory extends JpaRepository<Manager,Long>{
	

}
