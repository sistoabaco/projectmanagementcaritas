package com.dev.projectmanagementcaritas.controller;

import com.dev.projectmanagementcaritas.model.Employee;
import com.dev.projectmanagementcaritas.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@Controller
@RestController
@CrossOrigin("http://localhost:8081/")

public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("/employeeList")
    public List<Employee> employeesList(){
        return employeeRepo.findAll();
    }

    @PostMapping("saveEmployee")
    public void createEmployee(@RequestBody Employee employee){
        employeeRepo.save(employee);
    }
}
