package com.dev.projectmanagementcaritas.controller;

import com.dev.projectmanagementcaritas.model.Category;
import com.dev.projectmanagementcaritas.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin

public class CategoryController {
    @Autowired
    CategoryRepo categoriaRepo;

    @GetMapping("/categoryList")
    public List<Category> getCategory(){
        return categoriaRepo.findAll();
    }
}
