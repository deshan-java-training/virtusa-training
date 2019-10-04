package com.emsui.userinterface.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UiController {


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
}
