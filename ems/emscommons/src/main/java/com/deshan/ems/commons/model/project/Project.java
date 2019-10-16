package com.deshan.ems.commons.model.project;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="project")
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int projid;

    @Column(name = "name")
            @NotEmpty(message = "Project name cannot be null")
    String name;

    @NotEmpty(message = "Domain cannot be null")
    @Column(name="domain")
    String domain;

    @NotEmpty(message = "Status cannot be null")
    @Column(name = "status")
    String status;

    public Project(String name, String domain, String status) {
        this.name = name;
        this.domain = domain;
        this.status = status;
    }

    public Project() {
    }

    public int getProjid() {
        return projid;
    }

    public void setProjid(int projid) {
        this.projid = projid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
