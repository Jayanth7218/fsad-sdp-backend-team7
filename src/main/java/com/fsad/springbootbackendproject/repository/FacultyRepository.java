package com.fsad.springbootbackendproject.repository;

import com.fsad.springbootbackendproject.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    Faculty findByEmailAndPassword(String email, String password);
}