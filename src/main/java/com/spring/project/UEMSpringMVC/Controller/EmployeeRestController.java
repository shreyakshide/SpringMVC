package com.spring.project.UEMSpringMVC.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

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
    @PutMapping("/updateemp/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employeeDetails) {
        Employee existingEmployee = employeeServices.getEmployeeById(id);
        if (existingEmployee != null) {
            // Ensure the ID from the URL is set on the object
            employeeDetails.setId(id); 
            return employeeServices.updateEmployee(employeeDetails);
        }
        return null; // Or throw a ResourceNotFoundException
    }

    // 2. PARTIAL UPDATE (PATCH) - Updates only specific fields
    @PatchMapping("/patchemp/{id}")
    public Employee patchEmployee(@PathVariable int id, @RequestBody Employee patchData) {
        Employee existingEmployee = employeeServices.getEmployeeById(id);
        if (existingEmployee != null) {
            // Only update fields that are provided in the request
            if (patchData.getEmp_name() != null) existingEmployee.setEmp_name(patchData.getEmp_name());
            if (patchData.getEmp_email() != null) existingEmployee.setEmp_email(patchData.getEmp_email());
            if (patchData.getEmp_city() != null) existingEmployee.setEmp_city(patchData.getEmp_city());
            if (patchData.getEmp_contact_no() != null) existingEmployee.setEmp_contact_no(patchData.getEmp_contact_no());
            
            return employeeServices.updateEmployee(existingEmployee);
        }
        return null;
    }

    // 3. DELETE
    @DeleteMapping("/deleteemp/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeServices.deleteEmployee(id);
        return "Employee with ID " + id + " has been deleted successfully.";
    }
}
