package com.ems.projectsservice.model;

import javax.persistence.*;

@Entity
@Table(name="project")
public class Project {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int projid;

@Column(name = "name")
String name;

@Column(name="domain")
String domain;

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
