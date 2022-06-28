package com.dev.projectmanagementcaritas.controller;
import com.dev.projectmanagementcaritas.model.Project;
import com.dev.projectmanagementcaritas.repository.ProjectRepo;
import com.dev.projectmanagementcaritas.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//@Controller
@RestController
@CrossOrigin("http://localhost:3000/")

public class ProjectController {

    @Autowired
    ProjectRepo projectRepo;
    Services services;

    @GetMapping("/projectList")
    public List <Project> getProjects(){
        return projectRepo.findAll();
    }

    @GetMapping("/findProject/{id}")
    public Project findProject(@PathVariable int id){
        return projectRepo.findById(id).orElse(null);
    }

    @PostMapping("/saveProject")
    public String createProject(@RequestBody Project project){

        if(project.getDateEnd().compareTo(project.getDateStart()) > 0 &&
        project.getBudget() >= project.getBalanceAvailable()){

            project.setStatus("Activo");
            projectRepo.save(project);
            return "redirect:/projectList";
        }

        return "-1";
    }

    @PutMapping("/updateProject/{id}")
    public Project updateProject(@PathVariable int id, @RequestBody Project project){

        Project oldProject = projectRepo.findById(id).orElse(null);

        if(oldProject == null) return null;

        oldProject.setProjectName(project.getProjectName());
        oldProject.setBudget(project.getBudget());
        oldProject.setBalanceAvailable(project.getBalanceAvailable());
        oldProject.setDateStart(project.getDateStart());
        oldProject.setDateEnd(project.getDateEnd());
        oldProject.setStatus(project.getStatus());
        oldProject.setTypeCurrency(project.getTypeCurrency());
        oldProject.setLocalImplementation(project.getLocalImplementation());
        oldProject.setStatus(project.getStatus());

//        oldProject.setEmployee(project.getEmployee());
//        oldProject.setPartner(project.getPartner());

        return projectRepo.save(project);
    }

    @DeleteMapping("/deleteProject/{id}")
    public String updateProject(@PathVariable int id){
        projectRepo.deleteById(id);
        return "redirect:/projectList";
    }
}
