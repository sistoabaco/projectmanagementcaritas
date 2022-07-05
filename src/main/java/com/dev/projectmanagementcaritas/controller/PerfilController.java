package com.dev.projectmanagementcaritas.controller;

import com.dev.projectmanagementcaritas.model.Perfil;
import com.dev.projectmanagementcaritas.repository.PerfilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin

public class PerfilController {
    @Autowired
    PerfilRepo perfilRepo;

    @GetMapping("perfilList")
    public List<Perfil> getPerfil(){
        return perfilRepo.findAll();
    }
}
