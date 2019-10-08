package com.emsui.userinterface.model;

import java.util.List;

public class EmployeeProjectTaskList {

    int eptid;

    int empid;

    int projid;

    List<Integer> taskids;

    public EmployeeProjectTaskList(int empid, int projid, List<Integer> taskids) {
        this.empid = empid;
        this.projid = projid;
        this.taskids = taskids;
    }

    public EmployeeProjectTaskList() {
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

    public List<Integer> getTaskids() {
        return taskids;
    }

    public void setTaskids(List<Integer>taskids) {
        this.taskids = taskids;
    }
}
