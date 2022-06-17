package com.dev.projectmanagementcaritas.repository;

import com.dev.projectmanagementcaritas.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepo extends JpaRepository<Partner,Integer> {
    @Query("select p from Partner p where p.email = ?1")
    Partner findByEmail(String email);
}
