package com.smsui.smsui.model;

import java.util.List;

public class Student {


    private Integer sid;
    private String name;


    private Address address;

    private List<Telephone> numbers;


    private List<Project> projects;
    public Student() {
    }

    public Student(String name, Address address, List<Telephone> numbers, List<Project> projects) {
        this.name = name;
        this.address = address;
        this.numbers = numbers;
        this.projects = projects;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Telephone> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Telephone> numbers) {
        this.numbers = numbers;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Student(Integer sid, String name) {
        this.sid = sid;
        this.name = name;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
