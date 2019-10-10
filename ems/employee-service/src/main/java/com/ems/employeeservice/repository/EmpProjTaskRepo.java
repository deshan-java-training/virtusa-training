package com.ems.employeeservice.repository;

import com.ems.employeeservice.model.EmployeeProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface EmpProjTaskRepo extends JpaRepository<EmployeeProjectTask, Integer> {

    public  List<EmployeeProjectTask> findByEmployeeTaskCpk_Empid(Integer i);
  public List<EmployeeProjectTask> findByEmployeeTaskCpk_EmpidAndEmployeeTaskCpk_Projid(Integer empid, Integer projid);
}
