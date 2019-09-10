package com.java.dbconn.springdatajpaexample.service;

import com.java.dbconn.springdatajpaexample.model.Student;
import com.java.dbconn.springdatajpaexample.model.Telephone;
import com.java.dbconn.springdatajpaexample.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl {
@Autowired
StudentRepo stuRepo;

    public Student save(Student student){

        for(Telephone tp: student.getNumbers()){
            tp.setStudent(student);
        }
        return stuRepo.save(student);
    }

public List<Student> findAllStudents(){
        return stuRepo.findAll();
}


    public Student findStudentFromId(Integer id) {
        Optional<Student> std1 = stuRepo.findById(id);
        Student std2 = null;
       if(std1.isPresent()){
        std2= std1.get();
       }
       return std2;
    }
}
