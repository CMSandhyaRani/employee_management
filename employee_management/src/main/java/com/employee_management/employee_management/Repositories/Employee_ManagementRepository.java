package com.employee_management.employee_management.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_management.employee_management.Entities.Employee;

public interface Employee_ManagementRepository extends JpaRepository<Employee,Long>{

}
