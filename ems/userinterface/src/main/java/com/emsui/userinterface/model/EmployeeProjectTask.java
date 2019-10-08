package com.emsui.userinterface.model;

import java.util.List;

public class EmployeeProjectTask {

    int eptid;

    int empid;

    int projid;

    int taskids;

    public EmployeeProjectTask(int empid, int projid, int taskids) {
        this.empid = empid;
        this.projid = projid;
        this.taskids = taskids;
    }

    public EmployeeProjectTask() {
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

    public int getTaskids() {
        return taskids;
    }

    public void setTaskids(int taskids) {
        this.taskids = taskids;
    }
}
