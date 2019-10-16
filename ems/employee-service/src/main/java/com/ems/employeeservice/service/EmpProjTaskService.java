package com.ems.employeeservice.service;

import com.deshan.ems.commons.model.employee.EmployeeProjectTask;
import com.deshan.ems.commons.model.project.Project;
import com.deshan.ems.commons.model.task.Task;
import com.ems.employeeservice.accesstoken.AccessTokenConfigurer;
import com.ems.employeeservice.repository.EmpProjTaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpProjTaskService {
    @Autowired
    RestTemplate restTemplate;
    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @Autowired
    EmpProjTaskRepo empProjTaskRepo;

public List<EmployeeProjectTask> findProjectsByEmpId(int i){
 return    empProjTaskRepo.findByEmployeeTaskCpk_Empid(i);
}
public List<EmployeeProjectTask> saveProjectTasks(List<EmployeeProjectTask> employeeProjectTasks){
    return empProjTaskRepo.saveAll(employeeProjectTasks);
}
public List<Task> findTasksByProjectEmployee(int empid, int projid) {
    List<EmployeeProjectTask> employeeProjectTasks = empProjTaskRepo.findByEmployeeTaskCpk_EmpidAndEmployeeTaskCpk_Projid(empid, projid);
String neededTasks = employeeProjectTasks.stream().map(nt-> String.valueOf(nt.getEmployeeTaskCpk().getTaskids())).collect(Collectors.joining(","));
HttpHeaders httpHeaders = new HttpHeaders();
httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());

HttpEntity<Task> httpEntity = new HttpEntity<Task>(httpHeaders);
List<Task> fetchedListTasks = new ArrayList<Task>();
if(!neededTasks.isEmpty()){
    ResponseEntity<List> taskList = restTemplate.exchange("http://ems-tasks:8094/tasks/{list}", HttpMethod.GET, httpEntity, List.class, neededTasks);
    fetchedListTasks= taskList.getBody();
}


    return fetchedListTasks;
    }

    public List<Project> getProjectsOfEmployee(int empid) {
        List<EmployeeProjectTask> projectList = empProjTaskRepo.findByEmployeeTaskCpk_Empid(empid);
        String projectIdString = projectList.stream().map(s-> String.valueOf(s.getEmployeeTaskCpk().getProjid())).collect(Collectors.joining(","));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
        HttpEntity<Project> httpEntity = new HttpEntity<Project>(httpHeaders);
        List<Project> projList = new ArrayList<>();

        if(!projectIdString.isEmpty()){
            ResponseEntity<List<Project>> responseEntity =restTemplate.exchange("http://ems-project:8091/projects-list/{id}", HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Project>>() {
            }, projectIdString);
            projList = responseEntity.getBody();
        }

        return projList;
    }


    public Project getProjectOfEmployee(int projid) {

    HttpHeaders httpHeaders = new HttpHeaders();

    httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
    HttpEntity<Project> entityProject = new HttpEntity<Project>(httpHeaders);

  ResponseEntity<Project> getProject = restTemplate.exchange("http://ems-project:8091/projects/{projid}", HttpMethod.GET, entityProject, Project.class, projid);
   Project fetchedProject = getProject.getBody();

   return fetchedProject;

    }
}
