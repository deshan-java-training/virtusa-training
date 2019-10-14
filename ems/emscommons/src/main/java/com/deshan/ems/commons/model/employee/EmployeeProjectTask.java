package com.deshan.ems.commons.model.employee;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "emp_proj_tasks")
@Entity
public class EmployeeProjectTask {

    @EmbeddedId
    private EmployeeTaskCpk employeeTaskCpk;

    public EmployeeTaskCpk getEmployeeTaskCpk() {
        return employeeTaskCpk;
    }

    public void setEmployeeTaskCpk(EmployeeTaskCpk employeeTaskCpk) {
        this.employeeTaskCpk = employeeTaskCpk;
    }
    public EmployeeProjectTask(EmployeeTaskCpk employeeTaskCpk) {
        this.employeeTaskCpk = employeeTaskCpk;
    }

    public EmployeeProjectTask() {
    }

    @Embeddable
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