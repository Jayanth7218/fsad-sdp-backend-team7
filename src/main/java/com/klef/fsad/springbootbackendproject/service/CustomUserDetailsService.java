package com.klef.fsad.springbootbackendproject.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.klef.fsad.springbootbackendproject.entity.Faculty;
import com.klef.fsad.springbootbackendproject.entity.Student;
import com.klef.fsad.springbootbackendproject.repository.FacultyRepository;
import com.klef.fsad.springbootbackendproject.repository.StudentRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService 
{
    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private FacultyRepository facultyRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
    {
        // Try Student
        Student student = studentRepo.findByEmail(email);
        if (student != null) 
        {
            return new User(
                    student.getEmail(),
                    student.getPassword(),
                    Collections.singleton(() -> "ROLE_STUDENT")
            );
        }

        // Try Faculty
        Faculty faculty = facultyRepo.findByEmail(email);
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
}