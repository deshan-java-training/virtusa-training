package com.emsui.userinterface.controller;

import com.emsui.userinterface.accesstoken.AccessTokenConfigurer;
import com.emsui.userinterface.model.Employee;
import com.emsui.userinterface.model.Project;
import com.emsui.userinterface.model.Task;
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
    public String showOpertations() {
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

        ResponseEntity<Task> responseEntity = restTemplate.exchange("http://localhost:8065/tasks",HttpMethod.POST, httpEntity, Task.class);
        if(responseEntity.getStatusCodeValue()==200){
            return "redirect:tasks";
        }else {
            return "task-list";
        }
}

}