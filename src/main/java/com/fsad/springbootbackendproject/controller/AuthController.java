package com.fsad.springbootbackendproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fsad.springbootbackendproject.entity.Student;
import com.fsad.springbootbackendproject.service.AuthService;

@RestController
@RequestMapping("/authapi")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/login")
    public Student login(@RequestBody Student request) {
        return service.login(request.getEmail(), request.getPassword());
    }
}