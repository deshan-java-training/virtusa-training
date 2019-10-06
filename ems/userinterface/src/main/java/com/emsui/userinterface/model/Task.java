package com.emsui.userinterface.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Task {

    int taskid;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    Date taskstart;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    Date taskdue;
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
