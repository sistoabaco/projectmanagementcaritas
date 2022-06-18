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

    @GetMapping("/findRole/{id}")
    public Role findRole(@PathVariable int id){
        return roleRepo.findById(id).orElse(null);
    }

    @PostMapping("/saveRole")
    public String createRole(@RequestBody Role role){
        roleRepo.save(role);
        return "redirect:/roleList";
    }

    @PutMapping("/updateRole/{id}")
    public Role updateRole(@PathVariable int id, @RequestBody Role role){
        Role oldRole = roleRepo.findById(id).orElse(null);
        if (oldRole == null) return null;

        oldRole.setDescription(role.getDescription());
        return roleRepo.save(oldRole);
    }
    @PutMapping("/deleteRole/{id}")
    public String deleteRole(@PathVariable int id){
        roleRepo.deleteById(id);
        return "redirect:/roleList";
    }
}
