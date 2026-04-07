package com.fsad.springbootbackendproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsad.springbootbackendproject.entity.Student;
import com.fsad.springbootbackendproject.repository.StudentRepository;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private StudentRepository repo;

    @Override
    public Student login(String email, String password) {
        Student student = repo.findByEmail(email).orElse(null);

        if (student != null && student.getPassword().equals(password)) {
            return student;
        }

        return null;
    }
}