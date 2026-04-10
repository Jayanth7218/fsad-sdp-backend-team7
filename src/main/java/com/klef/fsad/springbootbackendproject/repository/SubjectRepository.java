package com.klef.fsad.springbootbackendproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.fsad.springbootbackendproject.entity.*;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    List<Subject> findByFaculty_Id(int facultyId);
}