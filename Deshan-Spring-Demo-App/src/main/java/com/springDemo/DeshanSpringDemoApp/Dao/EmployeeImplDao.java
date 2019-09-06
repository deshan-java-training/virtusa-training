package com.springDemo.DeshanSpringDemoApp.Dao;

import com.springDemo.DeshanSpringDemoApp.entities.Employees;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeImplDao implements EmpDaoIf {
@Autowired
private EntityManager entityManager;

    @Override
    @Transactional
    public List<Employees> showAllEmployees() {

Session session = entityManager.unwrap(Session.class);

//        Query<Employees> q1 = session.createQuery("from Employees", Employees.class);
        Query<Employees> q1 =session.getNamedQuery("names");
        List<Employees> emps = q1.getResultList();
        return emps;


    }
}
