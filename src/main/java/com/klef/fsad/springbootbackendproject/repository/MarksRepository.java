package com.klef.fsad.springbootbackendproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.fsad.springbootbackendproject.entity.*;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Integer> {
	
    List<Marks> findByStudent_Id(int studentId);
    
    List<Marks> findBySubject_Id(int subjectId);
}