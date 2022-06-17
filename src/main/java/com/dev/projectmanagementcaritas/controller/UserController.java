package com.dev.projectmanagementcaritas.controller;

import com.dev.projectmanagementcaritas.repository.UserRepo;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin("http://localhost:3000/")

public class UserController {
    @Autowired
    UserRepo userRepo;

//    public String loggedUser() {
//        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName();
//    }
}
