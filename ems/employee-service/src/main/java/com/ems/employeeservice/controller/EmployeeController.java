package com.ems.employeeservice.controller;

import com.ems.employeeservice.accesstoken.AccessTokenConfigurer;
import com.ems.employeeservice.model.Employee;
import com.ems.employeeservice.model.EmployeeProjectTask;
import com.ems.employeeservice.model.Project;
import com.ems.employeeservice.service.EmpProjTaskService;
import com.ems.employeeservice.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import javax.persistence.Access;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {
    @Autowired
    RestTemplate restTemplate;
    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
@Autowired
EmpService empService;
    @Autowired
    EmpProjTaskService empProjTaskService;

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public Employee saveEmployee(@RequestBody Employee employee){
    empService.saveEmployee(employee);
    return employee;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getAllEmployees(){
    return empService.getAllEmployees();
    }


   @RequestMapping(value = "/ept", method = RequestMethod.POST)
    public List<EmployeeProjectTask> saveEmpProjTask(@RequestBody List<EmployeeProjectTask> employeeProjectTask){

        return empProjTaskService.saveProjectTasks(employeeProjectTask);
   }


   @RequestMapping(value = "/emp-projects/{empid}")
    public @ResponseBody  List<Project> getProjectsOfEmployee(@PathVariable("empid") int empid){
List<EmployeeProjectTask> projectList = empProjTaskService.findProjectsByEmpId(empid);
String projectIdString = projectList.stream().map(s-> String.valueOf(s.getProjid())).collect(Collectors.joining(","));
       HttpHeaders httpHeaders = new HttpHeaders();
       httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
       HttpEntity<Project> httpEntity = new HttpEntity<Project>(httpHeaders);
      ResponseEntity<List<Project>> responseEntity =restTemplate.exchange("http://localhost:8091/projects/{id}", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Project>>() {
      }, projectIdString);
List<Project> projList = responseEntity.getBody();
return projList;

   }


   @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public Optional<Employee> getEmployeeById(@PathVariable int id){

        return empService.findEmpById(id);


   }
}
