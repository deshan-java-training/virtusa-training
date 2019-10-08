package com.ems.employeeservice.repository;

import com.ems.employeeservice.model.EmployeeProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpProjTaskRepo extends JpaRepository<EmployeeProjectTask, Integer> {

    public  List<EmployeeProjectTask> findByEmpid(int i);
}
