package com.spring.project.UEMSpringMVC.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.UEMSpringMVC.Service.*;
import com.spring.project.UEMSpringMVC.Entity.*;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    EmployeeServices employeeServices;

    @GetMapping("/allemp") 
    public List<Employee> getAllEmployee(){
        return employeeServices.getAllEmployees();
    }
    @PostMapping("/addemp")
	public Employee addEmployee(@RequestBody Employee employee) {
	    return employeeServices.storeEmployee(employee);
	}
}
