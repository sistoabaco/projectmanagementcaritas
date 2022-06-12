package com.dev.projectmanagementcaritas.repository;

import com.dev.projectmanagementcaritas.model.Employee;

import com.dev.projectmanagementcaritas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    @Query("select e from Employee  e where e.user = ?1")
    Employee findByEmployee(User user);
}
