package com.java.dbconn.springdatajpaexample.controller;

import com.java.dbconn.springdatajpaexample.model.Address;
import com.java.dbconn.springdatajpaexample.model.Project;
import com.java.dbconn.springdatajpaexample.model.Student;
import com.java.dbconn.springdatajpaexample.model.Telephone;
import com.java.dbconn.springdatajpaexample.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/sms")
public class StudentController {

    @Autowired
    StudentServiceImpl stService;

    @RequestMapping("/hello")
    public String greeting(){

        return "Hello from spring boot";
    }


    @RequestMapping(value ="/student", method = RequestMethod.GET)
    public List<Student> getStudent(){
return stService.findAllStudents();
    }
@RequestMapping(value="/student", method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
stService.save(student);
return student;
    }


    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)

    public Student findStudentById(@PathVariable Integer id){
return stService.findStudentFromId(id);
    }
}
