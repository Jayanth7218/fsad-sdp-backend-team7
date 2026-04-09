package com.fsad.springbootbackendproject.service;

import com.fsad.springbootbackendproject.entity.Marks;
import com.fsad.springbootbackendproject.entity.Student;
import com.fsad.springbootbackendproject.entity.Subject;
import java.util.List;

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