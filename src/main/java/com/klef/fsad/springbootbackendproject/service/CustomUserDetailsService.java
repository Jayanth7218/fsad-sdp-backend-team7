package com.klef.fsad.springbootbackendproject.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.klef.fsad.springbootbackendproject.entity.Admin;
import com.klef.fsad.springbootbackendproject.entity.Faculty;
import com.klef.fsad.springbootbackendproject.entity.Student;
import com.klef.fsad.springbootbackendproject.repository.AdminRepository;
import com.klef.fsad.springbootbackendproject.repository.FacultyRepository;
import com.klef.fsad.springbootbackendproject.repository.StudentRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService 
{
    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private FacultyRepository facultyRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
        // 🔥 1. ADMIN (FIRST)
    	Admin admin = adminRepo.findByUsername(username);

    	// 🔥 DEBUG (paste here)
    	System.out.println("LOGIN USERNAME: [" + username + "]");
    	System.out.println("ADMIN FOUND: " + admin);
    	
        if (admin != null) 
        {
            return new User(
                admin.getUsername(),
                admin.getPassword(),
                Collections.singleton(() -> "ROLE_ADMIN")
            );
        }

        
        // 🔥 2. STUDENT
        Student student = studentRepo.findByEmail(username);
        if (student != null) 
        {
            return new User(
                student.getEmail(),
                student.getPassword(),
                Collections.singleton(() -> "ROLE_STUDENT")
            );
        }

        // 🔥 3. FACULTY
        Faculty faculty = facultyRepo.findByEmail(username);
        if (faculty != null) 
        {
            return new User(
                faculty.getEmail(),
                faculty.getPassword(),
                Collections.singleton(() -> "ROLE_FACULTY")
            );
        }

        throw new UsernameNotFoundException("User not found");
    }
    
    public int getUserIdByUsername(String username) {
        if (username.contains("@")) {
            Student s = studentRepo.findByEmail(username);
            if (s != null) return s.getId();

            Faculty f = facultyRepo.findByEmail(username);
            if (f != null) return f.getId();
        }
        return -1;
    }
}