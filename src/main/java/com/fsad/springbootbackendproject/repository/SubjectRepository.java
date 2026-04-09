package com.fsad.springbootbackendproject.repository;

import com.fsad.springbootbackendproject.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    List<Subject> findByFaculty_Id(int facultyId);
}