package com.fsad.springbootbackendproject.service;

import com.fsad.springbootbackendproject.entity.Admin;
import com.fsad.springbootbackendproject.entity.Faculty;
import com.fsad.springbootbackendproject.entity.Marks;
import com.fsad.springbootbackendproject.entity.Student;
import java.util.List;

public interface AdminService {
  
  
    Admin verifyAdminLogin(String username, String password);
    
    // Faculty operations
    
    public String addFaculty(Faculty faculty);
    
    public List<Faculty> getAllFaculty();
    
    public boolean deleteFacultyById(int id);
    
    // Student operations
    public List<Student> getAllStudents();
    
    public boolean deleteStudentById(int id);
    
    List<Marks> getMarksByStudentId(int studentId);
    
}