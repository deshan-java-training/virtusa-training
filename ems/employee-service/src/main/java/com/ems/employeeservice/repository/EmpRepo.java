package com.ems.employeeservice.repository;

import com.deshan.ems.commons.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
