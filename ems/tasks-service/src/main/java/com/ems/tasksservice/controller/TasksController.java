package com.ems.tasksservice.controller;

import com.ems.tasksservice.model.Task;
import com.ems.tasksservice.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TasksController {
@Autowired
TasksService tasksService;

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_manager') AND hasAuthority('create_perm')")
    public Task saveTask(@RequestBody Task task){
    tasksService.saveTask(task);
    return task;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<Task> getAllTasks(){
    return tasksService.getAllTasks();
    }

    @RequestMapping(value = "/tasks/{list}", method = RequestMethod.GET)
    public List<Task> getAllTasksOfIds(@PathVariable List<Integer> list){
        return tasksService.getEmpProjTasks(list);

    }

}
