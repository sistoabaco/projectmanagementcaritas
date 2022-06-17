package com.dev.projectmanagementcaritas.security;

import com.dev.projectmanagementcaritas.model.*;
import com.dev.projectmanagementcaritas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.sql.Date;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {
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

    @Override
    public void run(String...args) throws Exception {
        //Privilegios
        roleRepo.save(new Role(1,"ADMIN"));
        roleRepo.save(new Role(2,"USER"));
        roleRepo.save(new Role(3, "PARTNER"));
        roleRepo.save(new Role(4, "TEAM_LEADER"));
        roleRepo.save(new Role(14, "COORDENADOR"));
        roleRepo.save(new Role(5, "OFICIAL_DE_MEAL"));
        roleRepo.save(new Role(6, "GESTOR_DE_PROJECTOS"));
        roleRepo.save(new Role(7, "P_DIRECTOR"));
        roleRepo.save(new Role(8,"P_GESTOR FINANCEIRO"));
        roleRepo.save(new Role(9, "P_CONTABILISTA"));
        roleRepo.save(new Role(10, "P_LOGISTICA"));
        roleRepo.save(new Role(11, "P_SECRETARIA"));
        roleRepo.save(new Role(12, "P_FIEL DE ARMAZEM"));
        roleRepo.save(new Role(13, "P_TECNICOS DO CAMPO"));

        // Utilizadores
        userRepo.save(new User(1,"admin","zxcvb",
                Arrays.asList(roleRepo.findByRole("ADMIN"),
                        roleRepo.findByRole("USER"),
                        roleRepo.findByRole("PARTNER"))));

        userRepo.save(new User(2,"user","zxcvb",
                Arrays.asList(roleRepo.findByRole("USER"))));
        userRepo.save(new User(3,"partner","zxcvb",
                Arrays.asList(roleRepo.findByRole("PARTNER"))));

        //projecto
        projectRepo.save(new Project(1,"BHA", "Activo", 12000000.0,"Chiure",
                Date.valueOf("2020-08-01"), Date.valueOf( "2022-10-01"), "USD", 8276626.0));
        projectRepo.save(new Project(2,"Hungria", "Terminado", 8000000.0,"Mecufi",
                Date.valueOf("2020-08-01"), Date.valueOf( "2022-04-01"), "MZN", 100000.0));

        //Funcionario
        employeeRepo.save(new Employee(1, "Sisto","Abaco","Male",
                "Eduardo Mondlane", "+258 847 264 343", "abaco@gmail.com",
                "Pemba", Date.valueOf("2000-01-02"), Date.valueOf("2050-01-02"),
                Date.valueOf("2050-04-09"), userRepo.findByUsername("admin"),
                Arrays.asList(projectRepo.findByName("BHA"))));

        employeeRepo.save(new Employee(2, "cassimo","duarte","Male",
                "Alto-Jingone", "+258 877 285 434", "duarte@gmail.com",
                "Pemba",  Date.valueOf("2000-01-02"), Date.valueOf("2050-01-02"),
                Date.valueOf("2050-04-09"), userRepo.findByUsername("user"),
                Arrays.asList(projectRepo.findByName("Hungria"))));

        //Parceiro
        partnerRepo.save(new Partner(1, "USAID","123212343","Av. Marinal"
                ,"usaid@gmail.com",Arrays.asList(projectRepo.findByName("BHA"),
                projectRepo.findByName("Hungria")), userRepo.findByUsername("partner")));
    }
}
