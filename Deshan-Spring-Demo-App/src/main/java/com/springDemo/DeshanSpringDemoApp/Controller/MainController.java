package com.springDemo.DeshanSpringDemoApp.Controller;

import com.springDemo.DeshanSpringDemoApp.Dao.EmployeeImplDao;
import com.springDemo.DeshanSpringDemoApp.Dao.EmployeeRepository;
import com.springDemo.DeshanSpringDemoApp.entities.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

@Autowired
EmployeeImplDao emDao;
    @Autowired
    EmployeeRepository employeeRepository;

@GetMapping("/employees")
public List<Employees> showEmployees(){
    System.out.println("kkkkk");
    System.out.println(emDao.showAllEmployees());
return emDao.showAllEmployees();
}

    @GetMapping("/employeesT")
    public String showEmployeesT(){

        return employeeRepository.getName(1);
    }

}
