package com.emsui.userinterface.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Task {

    int taskid;

    String taskstart;

    String taskdue;
    String name;


    public Task() {
    }

    public Task(int taskid, String taskstart, String taskdue, String name) {
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

    public String getTaskstart() {
        return taskstart;
    }

    public void setTaskstart(String taskstart) {
        this.taskstart = taskstart;
    }

    public String getTaskdue() {
        return taskdue;
    }

    public void setTaskdue(String taskdue) {
        this.taskdue = taskdue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
