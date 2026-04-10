package com.klef.fsad.springbootbackendproject.service;

import java.util.List;

import com.klef.fsad.springbootbackendproject.entity.Marks;
import com.klef.fsad.springbootbackendproject.entity.Student;
import com.klef.fsad.springbootbackendproject.entity.Subject;

public interface StudentService {
  
  // login
    Student verifyStudentLogin(String email, String password);
    
    Student getStudentById(int id);

    // Subject operations
    List<Subject> getAllSubjects();

    // Marks operations
    List<Marks> getMarksByStudent(int studentId);
    
    // Student acc creation
    String studentRegistration(Student student);
}