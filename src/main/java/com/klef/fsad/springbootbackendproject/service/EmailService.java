package com.klef.fsad.springbootbackendproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendCredentials(String to, String name, String username, String password, String role) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject("Welcome to Student Performance System");

        message.setText(
                "Hello " + name + ",\n\n" +
                "Your account has been created successfully.\n\n" +
                "Role: " + role + "\n" +
                "Username: " + username + "\n" +
                "Password: " + password + "\n\n" +
                "Login here: http://localhost:5173/login\n\n" +
                "Thank you."
        );

        mailSender.send(message);
    }
    
    public void sendResetLink(String to, String name, String link)
    {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject("Password Reset Request");

        message.setText(
                "Hello " + name + ",\n\n" +
                "Click the link below to reset your password:\n" +
                link + "\n\n" +
                "This link expires in 15 minutes."
        );

        mailSender.send(message);
    }
}