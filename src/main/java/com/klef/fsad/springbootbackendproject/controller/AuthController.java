package com.klef.fsad.springbootbackendproject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.klef.fsad.springbootbackendproject.dto.AuthRequestDTO;
import com.klef.fsad.springbootbackendproject.security.JwtUtil;
import com.klef.fsad.springbootbackendproject.service.CustomUserDetailsService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController 
{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService service;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO request) 
    {
        try 
        {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getUsername(),   // ✅ ONLY username
                    request.getPassword()
                )
            );

            UserDetails userDetails = service.loadUserByUsername(request.getUsername());

            String role = userDetails.getAuthorities()
                    .iterator().next().getAuthority();

            String token = jwtUtil.generateToken(userDetails);
           
            int userId = service.getUserIdByUsername(request.getUsername());

            return ResponseEntity.ok(
                Map.of(
                    "token", token,
                    "role", role,
                    "username", request.getUsername(),
                    "userId", userId
                )
            );

        } 
        catch (Exception e) 
        {
            e.printStackTrace(); // 🔥 VERY IMPORTANT (see console)
            return ResponseEntity.status(401).body("Invalid Email or Password");
        }
    }
}