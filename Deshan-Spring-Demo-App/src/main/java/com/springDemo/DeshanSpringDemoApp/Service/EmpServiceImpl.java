package com.springDemo.DeshanSpringDemoApp.Service;

import com.springDemo.DeshanSpringDemoApp.Dao.EmployeeImplDao;
import com.springDemo.DeshanSpringDemoApp.entities.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpServiceIn {
    @Autowired
    private EmployeeImplDao empDao;

    @Override
    @Transactional
    public List<Employees> showAllEmployees() {
        return empDao.showAllEmployees();
    }
}
