package com.ems.tasksservice.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="task")
public class Task {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int taskid;



@Column(name="taskstart")
@DateTimeFormat(pattern = "MM-dd-yyyy")
    String taskstart;

@Column(name = "taskdue")
@DateTimeFormat(pattern = "MM-dd-yyyy")
String taskdue;

@Column(name = "name")
String name;


    public Task() {
    }

    public Task(String taskstart, String taskdue, String name) {
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
