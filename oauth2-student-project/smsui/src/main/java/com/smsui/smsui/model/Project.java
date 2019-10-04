package com.smsui.smsui.model;

import java.util.List;

public class Project {


    private Integer pid;
    private String project_name;

    private List<Student> students;
    public Integer getPid() {
        return pid;
    }

    public Project(String project_name) {
        this.project_name = project_name;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public Project() {
    }

}
