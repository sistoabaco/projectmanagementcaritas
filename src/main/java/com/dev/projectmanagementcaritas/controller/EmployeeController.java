package com.dev.projectmanagementcaritas.controller;

import com.dev.projectmanagementcaritas.model.*;
import com.dev.projectmanagementcaritas.repository.EmployeeRepo;
import com.dev.projectmanagementcaritas.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;

//@Controller
@RestController
@CrossOrigin("http://localhost:3000/")

public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    UserRepo userRepo;
//    @Autowired
//    BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/employeeList")
    public List<Employee> employeesList(){
        return employeeRepo.findAll();
    }

    @GetMapping("/findEmployee/{id}")
    public Employee findOne(@PathVariable int id){
        return employeeRepo.findById(id).orElse(null);
    }

    @PostMapping("/saveEmployee")
    public String createEmployee(@RequestBody Employee employee, @RequestBody User user,
                                @RequestParam Collection <Role> roles,@RequestParam Category category,
                               @RequestParam Collection <Project> projects){

        if (user.getUsername() .equals(userRepo.findByUsername(user.getUsername()))){
//            model.addAttribute("erro", "username existente!!! informe outro username");
            return "erro, username invalido!!! informe um email valido";
        }

        user.setRole(roles);
//        u.setPassword(passwordEncoder.encode(u.getPassword()));
        userRepo.save(user);

        employee.setUser(user);
        employee.setCategory(category);
        employee.setProject(projects);

        employeeRepo.save(employee);
        return"redirect:/employeeList";
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee){

        Employee oldEmployee = employeeRepo.findById(id).orElse(null);
        if (oldEmployee == null) return null;

        oldEmployee.setProject(employee.getProject());
        oldEmployee.setCategory(employee.getCategory());
        oldEmployee.setAddress(employee.getAddress());
        oldEmployee.setCellphone(employee.getCellphone());
        oldEmployee.setDateStart(employee.getDateStart());
        oldEmployee.setDateEnd(employee.getDateEnd());
        oldEmployee.setProvenance(employee.getProvenance());
        oldEmployee.setGender(employee.getGender());

        oldEmployee.setCategory(employee.getCategory());
        oldEmployee.setProject(employee.getProject());
//        oldEmployee.setUser(employee.getUser());

        return employeeRepo.save(oldEmployee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeRepo.deleteById(id);
        return "redirect:/employeeList";
    }
}
