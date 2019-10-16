package com.ems.employeeservice.controller;

import com.deshan.ems.commons.model.employee.Employee;
import com.deshan.ems.commons.model.employee.EmployeeProjectTask;
import com.deshan.ems.commons.model.project.Project;
import com.deshan.ems.commons.model.task.Task;
import com.ems.employeeservice.service.EmpProjTaskService;
import com.ems.employeeservice.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

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
