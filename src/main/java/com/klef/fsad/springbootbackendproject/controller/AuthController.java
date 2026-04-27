package com.klef.fsad.springbootbackendproject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.klef.fsad.springbootbackendproject.service.CustomUserDetailsService;
import com.klef.fsad.springbootbackendproject.service.StudentService;
import com.klef.fsad.springbootbackendproject.dto.AuthRequestDTO;
import com.klef.fsad.springbootbackendproject.security.JwtUtil;
import com.klef.fsad.springbootbackendproject.service.FacultyService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController 
{
    @Autowired
    private CustomUserDetailsService service;

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO request) 
    {
        try 
        {
            UserDetails userDetails = service.loadUserByUsername(request.getEmail());

            String role = userDetails.getAuthorities()
                    .iterator().next().getAuthority();

            if (!role.equalsIgnoreCase(request.getRole()))
            {
                return ResponseEntity.status(403).body("Invalid Role");
            }

            boolean isValid = passwordEncoder.matches(
                    request.getPassword(),
                    userDetails.getPassword()
            );

            if (!isValid)
            {
                return ResponseEntity.status(401).body("Login Invalid");
            }

            String token = jwtUtil.generateToken(userDetails);

            Object userObj;

            if (role.equalsIgnoreCase("ROLE_STUDENT"))
            {
                userObj = studentService.getStudentByEmail(request.getEmail());
            }
            else
            {
                userObj = facultyService.getFacultyByEmail(request.getEmail());
            }

            return ResponseEntity.ok(
                Map.of(
                    "token", token,
                    "role", role,
                    "user", userObj
                )
            );
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}