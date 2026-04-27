package com.klef.fsad.springbootbackendproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.fsad.springbootbackendproject.entity.*;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    Faculty findByEmailAndPassword(String email, String password);
    Faculty findByEmail(String email);

}