package com.emsui.userinterface.controller;

import com.emsui.userinterface.accesstoken.AccessTokenConfigurer;
import com.emsui.userinterface.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@EnableOAuth2Sso
public class UiController {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/")
    public String showLanding() {
        return "landing";
    }

    @RequestMapping(value = "/tasks")
    public String showTasks(Model model) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<List<Task>> responseEntity = restTemplate.exchange("http://localhost:8094/tasks", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Task>>() {
        });
        List<Task> taskList = responseEntity.getBody();
        model.addAttribute("tasks", taskList);
        return "tasks-list";
    }

    @RequestMapping(value = "/operations")
    public String showOpertations(Model model) {
        model.addAttribute("ept", new EmployeeProjectTask());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
        HttpEntity<String> httpEntity = new HttpEntity<String>(null,httpHeaders);
        ResponseEntity<List<Employee>> responseEntityEmployee = restTemplate.exchange("http://localhost:8092/employees", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Employee>>() {
        });
        List<Employee> empList = responseEntityEmployee.getBody();
        ResponseEntity<List<Project>> responseEntityProject = restTemplate.exchange("http://localhost:8091/projects", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Project>>() {
        });
        List<Project> projList = responseEntityProject.getBody();
        ResponseEntity<List<Task>> responseEntityTask = restTemplate.exchange("http://localhost:8094/tasks", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Task>>() {
        });
        List<Task> taskList = responseEntityTask.getBody();
        model.addAttribute("employees", empList);
        model.addAttribute("projects", projList);
        model.addAttribute("tasks", taskList);


        return "operations";
    }

    @RequestMapping(value = "/create-employee")
    public String createEmployee() {
        return "create-employee";
    }

    @RequestMapping(value = "/create-emp-req", method = RequestMethod.POST)
    public String createEmpRequest(@ModelAttribute Employee employee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());

        HttpEntity<Employee> employeeHttpEntity = new HttpEntity<Employee>(employee, httpHeaders);

            ResponseEntity<Employee> responseEntity = restTemplate.exchange("http://localhost:8092/employees", HttpMethod.POST, employeeHttpEntity, Employee.class);

            if (responseEntity.getStatusCodeValue() == 200) {
                return "redirect:employees";
            } else {
                return "create-employee";
            }



    }

    @RequestMapping(value = "/employees")
    public String showAllEmployees(Model model){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());

HttpEntity<String> httpEntity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange("http://localhost:8092/employees", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Employee>>() {
        });
    List<Employee> employees = responseEntity.getBody();
    model.addAttribute("employees", employees);
return "employee-list";
    }


    @RequestMapping(value = "/projects")
    public String showAllProjects(Model model){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
        HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);

        ResponseEntity<List<Project>> responseEntity = restTemplate.exchange("http://localhost:8091/projects", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Project>>() {
        });
        List<Project> projects = responseEntity.getBody();
        model.addAttribute("projects", projects);
        return "project-list";
    }


    @RequestMapping(value = "/create-proj-req", method = RequestMethod.POST)
    public String addProject(@ModelAttribute Project proj){


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());

        HttpEntity<Project> httpEntity = new HttpEntity<Project>(proj, httpHeaders);

        ResponseEntity<Project> projectResponseEntity = restTemplate.exchange("http://localhost:8091/projects", HttpMethod.POST, httpEntity, Project.class);
        if(projectResponseEntity.getStatusCodeValue()==200){
            return "redirect:projects";
        }else{
            return "create-project";
        }

    }

@RequestMapping(value = "/create-project")
    public String showCreateProjectForm(){
        return "create-project";
}

@RequestMapping(value = "/create-task")
    public String showCreateTaskForm(){

        return "create-task";
}

@RequestMapping(value = "/create-task-req", method = RequestMethod.POST)
    public String createRequestTask(@ModelAttribute Task task){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
        HttpEntity<Task> httpEntity = new HttpEntity<Task>(task, httpHeaders);

        ResponseEntity<Task> responseEntity = restTemplate.exchange("http://localhost:8094/tasks",HttpMethod.POST, httpEntity, Task.class);
        if(responseEntity.getStatusCodeValue()==200){
            return "redirect:tasks";
        }else {
            return "create-task";
        }
}

@RequestMapping(value = "/create-req-ept", method = RequestMethod.POST)
    public String saveEmployeeTasks(@ModelAttribute EmployeeProjectTaskList ept){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
    List<EmployeeProjectTask> empProTasks = new ArrayList<>();
            ept.getTaskids().forEach((et)->{
            EmployeeProjectTask employeeProjectTask = new EmployeeProjectTask();
            employeeProjectTask.setEmpid(ept.getEmpid());
            employeeProjectTask.setProjid(ept.getProjid());
            employeeProjectTask.setTaskids(et);
empProTasks.add(employeeProjectTask);
        });

        HttpEntity<List> httpEntity = new HttpEntity<List>(empProTasks, httpHeaders);

        ResponseEntity<List<EmployeeProjectTask>> responseEntity = restTemplate.exchange("http://localhost:8092/ept", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<List<EmployeeProjectTask>>() {
        });

        if(responseEntity.getStatusCodeValue()==200){

            return "redirect:operations";
        }else{
            return "employee-list";
        }

}
@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public String showEmpDetails(@PathVariable("id") int id, Model model){
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
    HttpEntity<Integer> httpEntity = new HttpEntity<Integer>(id, httpHeaders);
    ResponseEntity<List<Project>> responseEntity = restTemplate.exchange("http://localhost:8092/emp-projects/{id}", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Project>>() {
}, id);
ResponseEntity<Employee> employeeResponseEntity = restTemplate.exchange("http://localhost:8092/employees/{id}", HttpMethod.GET, httpEntity, Employee.class, id);
    List<Project> projectList = responseEntity.getBody();
Employee fetchedEmpt = employeeResponseEntity.getBody();
    model.addAttribute("projectsList", projectList);
model.addAttribute("employee", fetchedEmpt);
        return "employee-details";
}

}