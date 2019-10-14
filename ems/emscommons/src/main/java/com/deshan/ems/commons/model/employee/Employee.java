package com.deshan.ems.commons.model.employee;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dob;

    public Employee(String name, String email, Date age) {
        this.name = name;
        this.email = email;
        this.dob = age;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
