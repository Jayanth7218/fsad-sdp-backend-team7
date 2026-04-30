package com.klef.fsad.springbootbackendproject.service;

import com.klef.fsad.springbootbackendproject.entity.Admin;
import com.klef.fsad.springbootbackendproject.entity.Faculty;
import com.klef.fsad.springbootbackendproject.entity.Marks;
import com.klef.fsad.springbootbackendproject.entity.Student;
import com.klef.fsad.springbootbackendproject.repository.AdminRepository;
import com.klef.fsad.springbootbackendproject.repository.FacultyRepository;
import com.klef.fsad.springbootbackendproject.repository.MarksRepository;
import com.klef.fsad.springbootbackendproject.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private MarksRepository marksRepository;

    @Override
    public Admin verifyAdminLogin(String username, String password) {
        return adminRepository.findByUsername(username);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addFaculty(Faculty faculty)
    {
        System.out.println("RAW PASSWORD: " + faculty.getPassword()); // debug

        if (faculty.getPassword() == null || faculty.getPassword().isEmpty()) {
            throw new RuntimeException("Password is missing!");
        }

        // 🔥 ENCODE PASSWORD
        faculty.setPassword(passwordEncoder.encode(faculty.getPassword()));

        facultyRepository.save(faculty);

        return "Faculty Added Successfully";
    }

    @Override
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    @Override
    public boolean deleteFacultyById(int id) {
      
        if(facultyRepository.existsById(id)) 
        {
          
          facultyRepository.deleteById(id);
          
             return true;
        }
        return false;
    }

    @Override
    public List<Student> getAllStudents() 
    {
      
        return studentRepository.findAll();
    }

    @Override
    public boolean deleteStudentById(int id) 
    {
      
        if(studentRepository.existsById(id))
          {
          
          studentRepository.deleteById(id);
          
          return true;
          
          }
            
        return false;
    }
    
    @Override
    public List<Marks> getMarksByStudentId(int studentId)
    {
      
        return marksRepository.findByStudent_Id(studentId);
        
    }
    
    @Autowired
    private AdminRepository adminRepo;

    @Override
    public void saveAdmin(Admin admin)
    {
        adminRepo.save(admin);
    }
    
    
    
    
}