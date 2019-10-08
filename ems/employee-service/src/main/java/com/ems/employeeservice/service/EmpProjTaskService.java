package com.ems.employeeservice.service;

import com.ems.employeeservice.model.EmployeeProjectTask;
import com.ems.employeeservice.repository.EmpProjTaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpProjTaskService {

    @Autowired
    EmpProjTaskRepo empProjTaskRepo;

public List<EmployeeProjectTask> findProjectsByEmpId(int i){
 return    empProjTaskRepo.findByEmpid(i);
}
public List<EmployeeProjectTask> saveProjectTasks(List<EmployeeProjectTask> employeeProjectTasks){
    return empProjTaskRepo.saveAll(employeeProjectTasks);
}
}
