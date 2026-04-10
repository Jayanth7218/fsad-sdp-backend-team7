package com.klef.fsad.springbootbackendproject.controller;

import com.klef.fsad.springbootbackendproject.entity.*;
import com.klef.fsad.springbootbackendproject.repository.*;
import com.klef.fsad.springbootbackendproject.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {


    @Autowired
    private AdminService adminService;
    
    
    @GetMapping("/")
    public String homw()
    {
      return "FSAD SDP Project no 29";
    }

  
    @PostMapping("/login")
    public Admin verifyAdminLogin(@RequestParam String username,@RequestParam String password) 
    {
        return adminService.verifyAdminLogin(username, password);
    }

    // Faculty
    @PostMapping("/addFaculty")
    public ResponseEntity<String> addFaculty(@RequestBody Faculty faculty) 
    {
      try 
      {
        String output = adminService.addFaculty(faculty);
        return ResponseEntity.status(201).body(output);
      
    } 
      catch (Exception e) 
      {
      return ResponseEntity.status(500).body("Internal Server Error");
    }
         
    }

    @GetMapping("/getAllFaculty")
    public ResponseEntity<?> getAllFaculty() 
    {
      try {
        List<Faculty> fac = adminService.getAllFaculty();
        return ResponseEntity.ok(fac);
      
    } 
      catch (Exception e) {
        return ResponseEntity.status(500).body("Error Fetching Faculty");
      
      }
    }

    @DeleteMapping("/deleteFaculty/{id}")
    public ResponseEntity<String> deleteFacultyById(@PathVariable int id) {
      
      try 
      {
        boolean r = adminService.deleteFacultyById(id);
        if(r)
          return ResponseEntity.ok().body("Faculty Deleted Successfull");
        else
          return ResponseEntity.status(404).body("Faculty Not found");
    } 
      catch (Exception e) 
      {
      return ResponseEntity.status(500).body(e.getMessage());
    }
    }

    // Student
    @GetMapping("/getAllStudents")
    public ResponseEntity<?> getAllStudents() {
      
      try 
      {
        List<Student> std = adminService.getAllStudents();
        
        if(std.size()>0)
          return ResponseEntity.ok(std);
        else
          return ResponseEntity.noContent().build(); // 204 - non content
    } 
      catch (Exception e) 
      {
          return ResponseEntity.status(500).body("Error Fetching Customers");
      }
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
      try 
      {
        boolean sta = adminService.deleteStudentById(id);
        if(sta)
        return ResponseEntity.ok().body("Student Deleted Successfull");
        else
          return ResponseEntity.status(404).body("Student Not Found");
      
    } 
      catch (Exception e) 
      {
        return ResponseEntity.status(500).body(e.getMessage());
      
    }
    }
    
    
    @GetMapping("/getMarksByStudent/{studentId}")
    public ResponseEntity<?> getMarksByStudentId(@PathVariable int studentId)
    {
        try
        {
            List<Marks> marks = adminService.getMarksByStudentId(studentId);

            if(marks.size() == 0)
            {
                return ResponseEntity.status(204).body("No Marks Found ");
            }

            return ResponseEntity.status(200).body(marks);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).body("Error Fetching Marks");
        }
    }
    

}