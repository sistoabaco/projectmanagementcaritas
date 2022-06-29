package com.dev.projectmanagementcaritas.controller;

import com.dev.projectmanagementcaritas.model.*;
import com.dev.projectmanagementcaritas.repository.EmployeeRepo;
import com.dev.projectmanagementcaritas.repository.RoleRepo;
import com.dev.projectmanagementcaritas.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

//@Controller
@RestController
@CrossOrigin("http://localhost:3000/")

public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

//    record EmployeeRequest (int idEmployee, String firstName, String lastName, String gender,
//                            String address, String cellphone, String provenance, Date dateBirth,
//                            Date dateStart, Date dateEnd, User user, Category category,
//                            Collection<Project> project){}
//
//    record EmployeeResponse (int idEmployee, String firstName, String gender,
//                            String address, String cellphone, String provenance,
//                            Date dateStart, Date dateEnd, String user, String category,
//                            String project){}

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
                               @RequestParam Category category,
                               @RequestParam Collection <Project> projects){

        if (user.equals(userRepo.findByUsername(user.getUsername()))) {
//            model.addAttribute("erro", "username existente!!! informe outro username");
            return "erro, username invalido!!! informe um email valido";
        }

        switch (category.getDescription()){
            case "admin": user.setRole(Arrays.asList(roleRepo.findByRole("P_ADMIN"),
                    roleRepo.findByRole("P_USER"),
                    roleRepo.findByRole("P_PARTNER"))); break;
            case "user":user.setRole(Arrays.asList(roleRepo.findByRole("USER"))); break;
            case "partner":user.setRole(Arrays.asList(roleRepo.findByRole("PARTNER"))); break;
            default:user.setRole(Arrays.asList(roleRepo.findByRole("OTHER")));
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
