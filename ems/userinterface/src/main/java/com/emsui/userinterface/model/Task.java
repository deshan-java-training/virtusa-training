package com.emsui.userinterface.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Task {

    int taskid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Task Start field should not be empty")
    Date taskstart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Task Due field should not be empty")
    Date taskdue;

    @NotNull(message = "Task name cannot be null")
    @Size(min = 2, message = "Task name must have atleast two characters")
    String name;


    public Task() {
    }

    public Task(int taskid, Date taskstart, Date taskdue, String name) {
        this.taskid = taskid;
        this.taskstart = taskstart;
        this.taskdue = taskdue;
        this.name = name;
    }

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public Date getTaskstart() {
        return taskstart;
    }

    public void setTaskstart(Date taskstart) {
        this.taskstart = taskstart;
    }

    public Date getTaskdue() {
        return taskdue;
    }

    public void setTaskdue(Date taskdue) {
        this.taskdue = taskdue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
