package com.ems.tasksservice.service;

import com.deshan.ems.commons.model.task.Task;
import com.ems.tasksservice.repository.TasksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TasksService {

    @Autowired
    TasksRepo tasksRepo;

    public List<Task> getAllTasks(){
    return  tasksRepo.findAll();
    }

    public Task saveTask(Task task){
        return tasksRepo.save(task);
    }

    public List<Task> getEmpProjTasks(List<Integer> taskIds){

       return tasksRepo.findByTaskidIn(taskIds);

    }
}
