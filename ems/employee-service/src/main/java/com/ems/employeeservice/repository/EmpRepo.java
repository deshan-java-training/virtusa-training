package com.ems.employeeservice.repository;

import com.ems.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
