package com.dev.projectmanagementcaritas.controller;

import com.dev.projectmanagementcaritas.model.User;
import com.dev.projectmanagementcaritas.repository.UserRepo;
import com.dev.projectmanagementcaritas.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000/")

public class UserController {
    @Autowired
    UserRepo userRepo;
    Services services;

    @PostMapping("/login")
    public String login(@RequestBody User user){
        var u = services.login(user.getUsername(), user.getPassword());
        return "redirect:/findEmployeeByUser/{u}";
    }

    @GetMapping("/findEmployeeByUser")
    public String findEmployeeByUser(@RequestBody User user){
        var employee = services.findEmployeeByUser(user);
        int id = employee.getIdEmployee();

        return "redirect://findEmployee/{id}";
    }

//    public String loggedUser() {
//        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName();
//    }
}
