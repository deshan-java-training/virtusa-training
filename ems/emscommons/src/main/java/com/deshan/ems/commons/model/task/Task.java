package com.deshan.ems.commons.model.task;


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
    Date taskstart;

    @Column(name = "taskdue")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    Date taskdue;

    @Column(name = "name")
    String name;


    public Task() {
    }

    public Task(Date taskstart, Date taskdue, String name) {
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
