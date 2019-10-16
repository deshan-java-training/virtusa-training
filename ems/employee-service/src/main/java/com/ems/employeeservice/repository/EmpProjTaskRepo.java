package com.ems.employeeservice.repository;

import com.deshan.ems.commons.model.employee.EmployeeProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpProjTaskRepo extends JpaRepository<EmployeeProjectTask, Integer> {

    public  List<EmployeeProjectTask> findByEmployeeTaskCpk_Empid(Integer i);
  public List<EmployeeProjectTask> findByEmployeeTaskCpk_EmpidAndEmployeeTaskCpk_Projid(Integer empid, Integer projid);
}
