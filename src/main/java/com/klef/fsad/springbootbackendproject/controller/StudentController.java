package com.klef.fsad.springbootbackendproject.controller;

import com.klef.fsad.springbootbackendproject.entity.Marks;
import com.klef.fsad.springbootbackendproject.entity.Student;
import com.klef.fsad.springbootbackendproject.entity.Subject;
import com.klef.fsad.springbootbackendproject.service.StudentService;

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

   
    @GetMapping("/getAllSubjects")
    public ResponseEntity<?> getAllSubjects()
    {
        try
        {
            List<Subject> subjects = studentService.getAllSubjects();

            if(subjects.size() == 0)
            {
                return ResponseEntity.status(204).body("No Subjects Found");
            }

            return ResponseEntity.status(200).body(subjects);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).body("Error Fetching Subjects");
        }
    }


    @GetMapping("/getMarks/{studentId}")
    public ResponseEntity<?> getMarksByStudent(@PathVariable int studentId)
    {
        try
        {
            List<Marks> marks = studentService.getMarksByStudent(studentId);

            if(marks.size() == 0)
            {
                return ResponseEntity.status(204).body("No Marks Found");
            }

            return ResponseEntity.status(200).body(marks);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).body("Error Fetching Marks");
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