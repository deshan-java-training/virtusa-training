package com.ems.employeeservice.service;

import com.ems.employeeservice.model.Employee;
import com.ems.employeeservice.model.EmployeeProjectTask;
import com.ems.employeeservice.repository.EmpProjTaskRepo;
import com.ems.employeeservice.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    EmpRepo empRepo;

    public List<Employee> getAllEmployees(){
    return  empRepo.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return empRepo.save(employee);
    }

    public Optional<Employee> findEmpById(int id){
        return empRepo.findById(id);
    }


}
