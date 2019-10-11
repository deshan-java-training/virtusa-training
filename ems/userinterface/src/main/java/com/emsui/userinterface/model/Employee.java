package com.emsui.userinterface.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Employee {


    int empid;
@NotNull(message = "Employee name cannot be null")
    @Size(min = 2, message = "Employee Name must have atleast two characters")
    String name;

    @NotEmpty(message = "Email field should not be empty")
    @Email(regexp = "^(.+)@(.+)$", message = "Invalid email address")
    String email;

    @NotNull(message = "Date field should not be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dob;

    public Employee(String name, String email, Date dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
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
