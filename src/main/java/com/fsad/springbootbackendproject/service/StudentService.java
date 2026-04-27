package com.fsad.springbootbackendproject.service;

import com.fsad.springbootbackendproject.entity.Marks;
import com.fsad.springbootbackendproject.entity.Student;
import com.fsad.springbootbackendproject.entity.Subject;
import java.util.List;

public interface StudentService {
  
  
    Student verifyStudentLogin(String email, String password);
    
    Student getStudentById(int id);
    
    Student getStudentByEmail(String email);
    
    List<Subject> getAllSubjects();

    List<Marks> getMarksByStudent(int studentId);
    
    String studentRegistration(Student student);
}