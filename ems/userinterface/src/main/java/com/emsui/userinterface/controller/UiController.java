package com.emsui.userinterface.controller;

import com.deshan.ems.commons.model.employee.Employee;
import com.deshan.ems.commons.model.employee.EmployeeProjectTask;
import com.deshan.ems.commons.model.project.Project;
import com.deshan.ems.commons.model.task.Task;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.net.CookieManager;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableOAuth2Sso
public class UiController extends WebSecurityConfigurerAdapter {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**","/login/oauth2")
                .permitAll()
                .antMatchers("/create**")
                .hasRole("manager")
                .antMatchers("/operations")
                .hasRole("manager")

                .anyRequest()
        .authenticated()
        .and()
 .logout()
        .logoutSuccessUrl("/")
        .deleteCookies("KSESSIONID", "JSESSIONID")
        .invalidateHttpSession(true)

        ;

    }

    @RequestMapping("/home")
    public String showLogin(){
        return "landing";
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
        ResponseEntity<List<Task>> responseEntity = restTemplate.exchange("http://ems-tasks:8094/tasks", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Task>>() {
        });
        List<Task> taskList = responseEntity.getBody();
        model.addAttribute("tasks", taskList);
        return "tasks-list";
    }

    @RequestMapping(value = "/operations")
    public String showOpertations(Model model) {
        model.addAttribute("ept", new EmployeeProjectTaskList());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
        HttpEntity<String> httpEntity = new HttpEntity<String>(null,httpHeaders);
        ResponseEntity<List<Employee>> responseEntityEmployee = restTemplate.exchange("http://ems-employee:8092/employees", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Employee>>() {
        });
        List<Employee> empList = responseEntityEmployee.getBody();
        ResponseEntity<List<Project>> responseEntityProject = restTemplate.exchange("http://ems-project:8091/projects", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Project>>() {
        });
        List<Project> projList = responseEntityProject.getBody();
        ResponseEntity<List<Task>> responseEntityTask = restTemplate.exchange("http://ems-tasks:8094/tasks", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Task>>() {
        });
        List<Task> taskList = responseEntityTask.getBody();
        model.addAttribute("employees", empList);
        model.addAttribute("projects", projList);
        model.addAttribute("tasks", taskList);


        return "operations";
    }

    @RequestMapping(value = "/create-employee")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "create-employee";
    }

    @RequestMapping(value = "/create-emp-req", method = RequestMethod.POST)
    public String createEmpRequest(@Valid Employee employee, Errors errors, Model model) {
        if(errors.hasErrors()){
            return "create-employee";
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());

        HttpEntity<Employee> employeeHttpEntity = new HttpEntity<Employee>(employee, httpHeaders);

            ResponseEntity<Employee> responseEntity = restTemplate.exchange("http://ems-employee:8092/employees", HttpMethod.POST, employeeHttpEntity, Employee.class);

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
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange("http://ems-employee:8092/employees", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Employee>>() {
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

        ResponseEntity<List<Project>> responseEntity = restTemplate.exchange("http://ems-project:8091/projects", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Project>>() {
        });
        List<Project> projects = responseEntity.getBody();
        model.addAttribute("projects", projects);
        return "project-list";
    }

// Handling request for creating a project
    @RequestMapping(value = "/create-proj-req", method = RequestMethod.POST)
    public String addProject(@Valid Project proj, Errors errors){
if(errors.hasErrors()){
    return "create-project";
}
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());

        HttpEntity<Project> httpEntity = new HttpEntity<Project>(proj, httpHeaders);

        ResponseEntity<Project> projectResponseEntity = restTemplate.exchange("http://ems-project:8091/projects", HttpMethod.POST, httpEntity, Project.class);
        if(projectResponseEntity.getStatusCodeValue()==200){
            return "redirect:projects";
        }else{
            return "create-project";
        }

    }

    //Show template for creating project
@RequestMapping(value = "/create-project")
    public String showCreateProjectForm(Model model ){
        model.addAttribute("project",new Project());
        return "create-project";
}

    //Show template for create-task
@RequestMapping(value = "/create-task")
    public String showCreateTaskForm(Model model){
model.addAttribute("task", new Task());
        return "create-task";
}

//Create new task request
@RequestMapping(value = "/create-task-req", method = RequestMethod.POST)
    public String createRequestTask(@Valid Task task, Errors errors){

        if(errors.hasErrors()){
            return "create-task";
        }


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
        HttpEntity<Task> httpEntity = new HttpEntity<Task>(task, httpHeaders);

        ResponseEntity<Task> responseEntity = restTemplate.exchange("http://ems-tasks:8094/tasks",HttpMethod.POST, httpEntity, Task.class);
        if(responseEntity.getStatusCodeValue()==200){
            return "redirect:tasks";
        }else {
            return "create-task";
        }
}

//Create Employee Project Tasks From Operations
@RequestMapping(value = "/create-req-ept", method = RequestMethod.POST)
    public String saveEmployeeTasks(@ModelAttribute EmployeeProjectTaskList ept){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
    List<EmployeeProjectTask> empProTasks = new ArrayList<>();
            ept.getTaskids().forEach((et)->{
            EmployeeProjectTask.EmployeeTaskCpk employeeProjectTask = new EmployeeProjectTask.EmployeeTaskCpk();
            EmployeeProjectTask employeeProjectTaskParent = new EmployeeProjectTask();
            employeeProjectTask.setEmpid(ept.getEmpid());
            employeeProjectTask.setProjid(ept.getProjid());
            employeeProjectTask.setTaskids(et);
            employeeProjectTaskParent.setEmployeeTaskCpk(employeeProjectTask);
empProTasks.add(employeeProjectTaskParent);
        });

        HttpEntity<List> httpEntity = new HttpEntity<List>(empProTasks, httpHeaders);

        ResponseEntity<List<EmployeeProjectTask>> responseEntity = restTemplate.exchange("http://ems-employee:8092/ept", HttpMethod.POST, httpEntity, new ParameterizedTypeReference<List<EmployeeProjectTask>>() {
        });

        if(responseEntity.getStatusCodeValue()==200){

            return "redirect:operations";
        }else{
            return "employee-list";
        }

}


//Get all projects from an employee
@RequestMapping(value = "/employees/{id}/projects/", method = RequestMethod.GET)
    public String showEmpDetails(@PathVariable("id") int id, Model model){
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
    HttpEntity<Integer> httpEntity = new HttpEntity<Integer>(id, httpHeaders);
    ResponseEntity<List<Project>> responseEntity = restTemplate.exchange("http://ems-employee:8092/employees/{id}/projects", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Project>>() {
}, id);
ResponseEntity<Employee> employeeResponseEntity = restTemplate.exchange("http://ems-employee:8092/employees/{id}", HttpMethod.GET, httpEntity, Employee.class, id);
    List<Project> projectList = responseEntity.getBody();
Employee fetchedEmpt = employeeResponseEntity.getBody();
    model.addAttribute("projectsList", projectList);
model.addAttribute("employee", fetchedEmpt);
        return "employee-details";
}

//Get tasks allocated to a particular employee
@RequestMapping(value = "employees/{empid}/projects/{projid}/tasks/")
public String showTasksOfEmployeeProjects(@PathVariable int empid, @PathVariable int projid, Model model){

HttpHeaders httpHeaders = new HttpHeaders();
httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
List<Integer> passingInts = new ArrayList<Integer>();
passingInts.add(empid);
passingInts.add(projid);
HttpEntity<Task> idsHttpEntity = new HttpEntity<Task>(httpHeaders);
HttpEntity<Project> projectHttpEntity = new HttpEntity<Project>(httpHeaders);
ResponseEntity<List<Task>> taskList = restTemplate.exchange("http://ems-employee:8092/employees/{empid}/projects/{projid}/tasks", HttpMethod.GET, idsHttpEntity, new ParameterizedTypeReference<List<Task>>() {
}, empid, projid);

ResponseEntity<Project> assignedProject = restTemplate.exchange("http://ems-employee:8092/employees/{empid}/projects/{projid}", HttpMethod.GET, projectHttpEntity, Project.class,empid, projid);
List<Task> fetchedTasks = taskList.getBody();
Project fetchedProject = assignedProject .getBody();
model.addAttribute("taskList", fetchedTasks);
model.addAttribute("projectSingle", fetchedProject);
model.addAttribute("empid", empid);
        return "employee-proj-tasks";
}

}