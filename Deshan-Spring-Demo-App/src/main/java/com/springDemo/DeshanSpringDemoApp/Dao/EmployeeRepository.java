package com.springDemo.DeshanSpringDemoApp.Dao;

import com.springDemo.DeshanSpringDemoApp.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

//    List<Employees> findByIds(List<Integer> ids);

    @Query("SELECT em.name FROM Employees em Where em.id=:id")
    String getName(@Param("id") int id);

}
