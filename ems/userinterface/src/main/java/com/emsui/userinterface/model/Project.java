package com.emsui.userinterface.model;

import com.emsui.userinterface.validationAnnot.ValidateStrings;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Project {
    int projid;

    @NotNull(message = "Project name cannot be null")
    @Size(min = 2, message = "Project name must have atleast two characters")
    String name;

    String domain;

    String status;

    public Project(String name, String domain, String status) {
        this.name = name;
        this.domain = domain;
        this.status = status;
    }

    public Project() {
    }


    public void setProjid(int projid) {
        this.projid = projid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProjid() {
        return projid;
    }

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain;
    }

    public String getStatus() {
        return status;
    }
}
