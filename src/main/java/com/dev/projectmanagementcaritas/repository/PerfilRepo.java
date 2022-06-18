package com.dev.projectmanagementcaritas.repository;

import com.dev.projectmanagementcaritas.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepo extends JpaRepository<Perfil, Integer> {
}
