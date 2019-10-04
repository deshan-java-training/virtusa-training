package com.emsui.userinterface.controller;

import com.emsui.userinterface.accesstoken.AccessTokenConfigurer;
import com.emsui.userinterface.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
@EnableOAuth2Sso
public class UiController {
@Autowired
RestTemplate restTemplate;

@Bean
RestTemplate getRestTemplate(){
    return new RestTemplate();
}
    @RequestMapping(value = "/")
    public String showLanding(){
        return "landing";
    }

    @RequestMapping(value = "/employees")
    public String showEmployees(){
        return "employee-list";
    }
    @RequestMapping(value = "/projects")
    public String showProjects(){
        return "project-list";
    }
    @RequestMapping(value = "/tasks")
    public String showTasks(){
        return "tasks-list";
    }
    @RequestMapping(value = "/operations")
    public String showOpertations(){
        return "operations";
    }
    @RequestMapping(value = "/create-employee")
    public String createEmployee(){
        return "create-employee";
    }
    @RequestMapping(value = "/create-emp-req", method = RequestMethod.POST)
    public String createEmpRequest(@ModelAttribute Employee employee){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
        HttpEntity<Employee> employeeHttpEntity = new HttpEntity<Employee>(employee,httpHeaders);

    ResponseEntity<Employee> responseEntity = restTemplate.exchange("http://localhost:8092/employees", HttpMethod.POST, employeeHttpEntity,Employee.class);

return "redirect:employees";

    }
}
