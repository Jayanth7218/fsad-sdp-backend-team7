package com.klef.fsad.springbootbackendproject.service;

import java.util.List;

import com.klef.fsad.springbootbackendproject.entity.Marks;
import com.klef.fsad.springbootbackendproject.entity.Student;
import com.klef.fsad.springbootbackendproject.entity.Subject;

public interface StudentService {
  
  
    Student verifyStudentLogin(String email, String password);
    
    Student getStudentById(int id);
    
    Student getStudentByEmail(String email);
    
    List<Subject> getAllSubjects();

    List<Marks> getMarksByStudent(int studentId);
    
    String studentRegistration(Student student);
}