package com.dev.projectmanagementcaritas.service;

import com.dev.projectmanagementcaritas.model.Category;
import com.dev.projectmanagementcaritas.model.Employee;
import com.dev.projectmanagementcaritas.model.User;
import com.dev.projectmanagementcaritas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Arrays;

@Service
public class Services {
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    PartnerRepo partnerRepo;
    private PasswordEncoder passwordEncoder;

    public void setUserRole(User user, Category category){
        user.setUsername(passwordEncoder.encode(user.getPassword()));

        switch (category.getDescription()){
            case "admin": user.setRole(Arrays.asList(roleRepo.findByRole("P_ADMIN"),
                    roleRepo.findByRole("P_USER"),
                    roleRepo.findByRole("P_PARTNER"))); break;
            case "user":Arrays.asList(roleRepo.findByRole("USER")); break;
            case "partner":Arrays.asList(roleRepo.findByRole("PARTNER")); break;
            default:user.setRole(Arrays.asList(roleRepo.findByRole("OTHER")));
        }
    }

    public User login(String username, String password) {
        //find user by username
        var user = userRepo.findByUsername(username);

        if(!user.getUsername().equals(username))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid User");

        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password does not match");
        }

        return user;
    }

    public Employee findEmployeeByUser(User user) {
        return employeeRepo.findByEmployeeByUser(user);
    }
}
