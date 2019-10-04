package com.ems.employeeservice.model;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int empid;

@Column(name = "name")
String name;

@Column(name="email")
String email;

@Column(name = "age")
int age;

    public Employee(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Employee() {
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}