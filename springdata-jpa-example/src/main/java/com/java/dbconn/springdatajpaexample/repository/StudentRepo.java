package com.java.dbconn.springdatajpaexample.repository;

import com.java.dbconn.springdatajpaexample.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {


}
