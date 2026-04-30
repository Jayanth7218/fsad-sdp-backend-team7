package com.klef.fsad.springbootbackendproject.service;

import java.util.List;

import com.klef.fsad.springbootbackendproject.entity.Admin;
import com.klef.fsad.springbootbackendproject.entity.Faculty;
import com.klef.fsad.springbootbackendproject.entity.Marks;
import com.klef.fsad.springbootbackendproject.entity.Student;

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
    public void saveAdmin(Admin admin);
    
    
    
}