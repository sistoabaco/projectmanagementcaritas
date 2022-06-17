package com.dev.projectmanagementcaritas.controller;

import com.dev.projectmanagementcaritas.model.Role;
import com.dev.projectmanagementcaritas.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@CrossOrigin("http://localhost:3000/")

public class RoleController {
    @Autowired
    RoleRepo roleRepo;

    @GetMapping("/roleList")
    public List <Role> getRoles(){
        return roleRepo.findAll();
    }

    @PostMapping("/saveRole")
    public String createRole(@RequestBody Role role){
        roleRepo.save(role);
        return "Sucessful";
    }
}
