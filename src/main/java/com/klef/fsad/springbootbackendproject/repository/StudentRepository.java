package com.klef.fsad.springbootbackendproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.fsad.springbootbackendproject.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByEmailAndPassword(String email, String password);
}