package com.fsad.springbootbackendproject.service;

import com.fsad.springbootbackendproject.entity.Student;

public interface AuthService {

    Student login(String email, String password);
}