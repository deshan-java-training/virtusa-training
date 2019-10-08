package com.ems.employeeservice.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "emp_proj_tasks")
@Entity
public class EmployeeProjectTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int eptid;

    @Column(name = "empid")
    int empid;

    @Column(name = "projid")
    int projid;

    @Column(name = "taskids")
   String taskids;


    public EmployeeProjectTask() {
    }

    public EmployeeProjectTask(int empid, int projid, String taskids) {
        this.empid = empid;
        this.projid = projid;
        this.taskids = taskids;
    }

    public int getEptid() {
        return eptid;
    }

    public void setEptid(int eptid) {
        this.eptid = eptid;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public int getProjid() {
        return projid;
    }

    public void setProjid(int projid) {
        this.projid = projid;
    }

    public String getTaskids() {
        return taskids;
    }

    public void setTaskids(String taskids) {
        this.taskids = taskids;
    }
}
