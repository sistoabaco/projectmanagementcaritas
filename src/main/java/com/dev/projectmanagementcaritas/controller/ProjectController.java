package com.dev.projectmanagementcaritas.controller;

import com.dev.projectmanagementcaritas.model.Project;
import com.dev.projectmanagementcaritas.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@CrossOrigin("http://localhost:3000/")

public class ProjectController {

    @Autowired
    ProjectRepo projectRepo;

    @GetMapping("/projectList")
    public List <Project> getProjects(){
        return projectRepo.findAll();
    }

    @PostMapping("/saveProject")
    public void createProject(@RequestBody Project project){
        projectRepo.save(project);
    }
}
