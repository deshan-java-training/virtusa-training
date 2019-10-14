package com.ems.employeeservice.controller;

import com.ems.employeeservice.accesstoken.AccessTokenConfigurer;
import com.ems.employeeservice.model.Employee;
import com.ems.employeeservice.model.EmployeeProjectTask;
import com.ems.employeeservice.model.Project;
import com.ems.employeeservice.model.Task;
import com.ems.employeeservice.service.EmpProjTaskService;
import com.ems.employeeservice.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import javax.persistence.Access;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

@Autowired
EmpService empService;
    @Autowired
    EmpProjTaskService empProjTaskService;

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_manager') AND hasAuthority('create_perm')")
    public Employee saveEmployee(@RequestBody Employee employee){
    empService.saveEmployee(employee);
    return employee;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getAllEmployees(){
    return empService.getAllEmployees();
    }


   @RequestMapping(value = "/ept", method = RequestMethod.POST)
   @PreAuthorize("hasRole('ROLE_manager') AND hasAuthority('create_perm')")
    public List<EmployeeProjectTask> saveEmpProjTask(@RequestBody List<EmployeeProjectTask> employeeProjectTask){

        return empProjTaskService.saveProjectTasks(employeeProjectTask);
   }


   @RequestMapping(value = "/employees/{empid}/projects")
    public @ResponseBody  List<Project> getProjectsOfEmployee(@PathVariable("empid") int empid){
return empProjTaskService.getProjectsOfEmployee(empid);

   }

   @RequestMapping(value = "/employees/{empid}/projects/{projid}")
   public Project getProjectOfEmployee(@PathVariable int empid, @PathVariable int projid){
        return empProjTaskService.getProjectOfEmployee(projid);
   }

   @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public Optional<Employee> getEmployeeById(@PathVariable int id){

        return empService.findEmpById(id);


   }

   @RequestMapping(value = "/employees/{empid}/projects/{projid}/tasks")
   public List<Task> getTasksOfEmployeeProject(@PathVariable int empid, @PathVariable int projid){

return  empProjTaskService.findTasksByProjectEmployee(empid,projid);

   }


}
