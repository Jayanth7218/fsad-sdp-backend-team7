package com.fsad.springbootbackendproject.controller;


import com.fsad.springbootbackendproject.entity.Student;
import com.fsad.springbootbackendproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home()
    {
        return "Student Home";
    }

    @PostMapping("/login")
    public ResponseEntity<?> verifyStudentLogin(@RequestBody Student std)
    {
        try
        {
            Student s = studentService.verifyStudentLogin(std.getEmail(), std.getPassword());

            if(s != null)
            {
                return ResponseEntity.status(200).body(s);
            }
            else
            {
                return ResponseEntity.status(401).body("Login Invalid");
            }
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> studentRegistration(@RequestBody Student std)
    {
        try
        {
            String op = studentService.studentRegistration(std);
            return ResponseEntity.status(201).body(op);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
}