package com.ems.employeeservice.controller;

import com.ems.employeeservice.model.Employee;
import com.ems.employeeservice.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
@Autowired
EmpService empService;

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public Employee saveEmployee(@RequestBody Employee employee){
    empService.saveEmployee(employee);
    return employee;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getAllEmployees(){
    return empService.getAllEmployees();
    }

}
