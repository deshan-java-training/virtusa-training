package com.emsui.userinterface.model;

import java.io.Serializable;
import java.util.List;

public class EmployeeProjectTask {

    EmployeeTaskCpk employeeTaskCpk;

    public EmployeeTaskCpk getEmployeeTaskCpk() {
        return employeeTaskCpk;
    }

    public void setEmployeeTaskCpk(EmployeeTaskCpk employeeTaskCpk) {
        this.employeeTaskCpk = employeeTaskCpk;
    }

    public static class  EmployeeTaskCpk implements Serializable {


        int empid;
        int projid;
        int taskids;

        public EmployeeTaskCpk() {
        }

        public EmployeeTaskCpk(int empid, int projid, int taskids) {
            this.empid = empid;
            this.projid = projid;
            this.taskids = taskids;
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
}
