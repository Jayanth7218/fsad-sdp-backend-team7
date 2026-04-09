package com.fsad.springbootbackendproject.repository;

import com.fsad.springbootbackendproject.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Integer> {
	
    List<Marks> findByStudent_Id(int studentId);
    
    List<Marks> findBySubject_Id(int subjectId);
}