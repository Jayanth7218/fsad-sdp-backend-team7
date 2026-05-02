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
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private FacultyRepository facultyRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("LOGIN USERNAME: " + username);

        // ✅ ADMIN
        Admin admin = adminRepo.findByUsername(username);
        if (admin != null) {
            System.out.println("ADMIN FOUND");

            return new User(
                admin.getUsername(),
                admin.getPassword(),
                Collections.singleton(() -> "ROLE_ADMIN")
            );
        }

        Student student = studentRepo.findByEmail(username);
        if (student != null) {
            System.out.println("STUDENT FOUND");

            return new User(
                student.getEmail(),
                student.getPassword(),
                Collections.singleton(() -> "ROLE_STUDENT")
            );
        }

        Faculty faculty = facultyRepo.findByEmail(username);
        if (faculty != null) {
            System.out.println("FACULTY FOUND");

            return new User(
                faculty.getEmail(),
                faculty.getPassword(),
                Collections.singleton(() -> "ROLE_FACULTY")
            );
        }

        throw new UsernameNotFoundException("User not found");
    }
}