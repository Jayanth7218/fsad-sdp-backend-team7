package com.klef.fsad.springbootbackendproject.controller;

import com.klef.fsad.springbootbackendproject.entity.Faculty;
import com.klef.fsad.springbootbackendproject.entity.Marks;
import com.klef.fsad.springbootbackendproject.entity.Student;
import com.klef.fsad.springbootbackendproject.entity.Subject;
import com.klef.fsad.springbootbackendproject.service.FacultyService;
import com.klef.fsad.springbootbackendproject.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/faculty")
@CrossOrigin("*")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/")
    public String home() {
        return "Faculty Home";
    }

    @PostMapping("/login")
    public ResponseEntity<?> verifyFacultyLogin(@RequestBody Faculty faculty) {
        try {
            Faculty f = facultyService.verifyFacultyLogin(faculty.getEmail(), faculty.getPassword());

            if (f != null) {
                return ResponseEntity.status(200).body(f);
            } else {
                return ResponseEntity.status(401).body("Login Invalid");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
    @PostMapping("/addFaculty")
    public ResponseEntity<?> addFaculty(@RequestBody Faculty faculty) {
        try {
            String op = facultyService.addFaculty(faculty);
            return ResponseEntity.ok(op);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding faculty");
        }
    }
    
    @DeleteMapping("/deleteFaculty/{id}")
    public ResponseEntity<?> deleteFaculty(@PathVariable int id) {
        try {
            String msg = facultyService.deleteFaculty(id);
            return ResponseEntity.ok(msg);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting faculty");
        }
    }
    
    @GetMapping("/getAllFaculty")
    public ResponseEntity<?> getAllFaculty() {
        try {
            List<Faculty> list = facultyService.getAllFaculty();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching faculty");
        }
    }
    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudents")
    public ResponseEntity<?> getAllStudents() {
        try {
            List<Student> students = studentService.getAllStudents();
            return ResponseEntity.ok(students);
        } catch (Exception e) {
            e.printStackTrace(); // 🔥 VERY IMPORTANT
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        try {
            String msg = facultyService.deleteStudent(id);
            return ResponseEntity.ok(msg);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting student");
        }
    }
    
    

    @PostMapping("/addSubject")
    public ResponseEntity<?> addSubject(@RequestBody Subject subject) {
        try {
            String op = facultyService.addSubject(subject);
            return ResponseEntity.ok(op);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error Adding Subject");
        }
    }

    @GetMapping("/getSubjects/{facultyId}")
    public ResponseEntity<?> getSubjectsByFaculty(@PathVariable int facultyId) {
        try {
            List<Subject> sub = facultyService.getSubjectsByFaculty(facultyId);
            return ResponseEntity.ok(sub);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error Fetching Subjects");
        }
    }
    @GetMapping("/getAllSubjects")
    public ResponseEntity<?> getAllSubjects() {
        try {
            List<Subject> subjects = facultyService.getAllSubjects();
            return ResponseEntity.ok(subjects);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching subjects");
        }
    }

    @DeleteMapping("/deleteSubject/{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable int id) {
        try {
            String op = facultyService.deleteSubject(id);
            return ResponseEntity.ok(op);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error Deleting Subject");
        }
    }

    @PostMapping("/addMarks")
    public ResponseEntity<?> addMarks(@RequestBody Marks marks) {
        try {
            String op = facultyService.addMarks(marks);
            return ResponseEntity.ok(op);
        } catch (Exception e) {
            e.printStackTrace();   // 👈 ADD THIS
            return ResponseEntity.status(500).body("Error Adding Marks");
        }
    }

    @PutMapping("/updateMarks/{id}")
    public ResponseEntity<?> updateMarks(@PathVariable int id, @RequestParam int marksObtained) {
        try {
            String op = facultyService.updateMarks(id, marksObtained);
            return ResponseEntity.ok(op);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error Updating Marks");
        }
    }

    @GetMapping("/getMarksBySubject/{subjectId}")
    public ResponseEntity<?> getMarksBySubject(@PathVariable int subjectId) {
        try {
            List<Marks> marks = facultyService.getMarksBySubject(subjectId);
            return ResponseEntity.ok(marks);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error Fetching Marks");
        }
    }
    
    @GetMapping("/getAllMarks")
    public ResponseEntity<?> getAllMarks()
    {
        try
        {
            List<Marks> marks = facultyService.getAllMarks();

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
    
    @DeleteMapping("/deleteMarks/{id}")
    public ResponseEntity<?> deleteMarks(@PathVariable int id)
    {
        try
        {
            String op = facultyService.deleteMarks(id);
            return ResponseEntity.ok(op);
        }
        
        catch(Exception e)
        {
        	
            return ResponseEntity.status(500).body("Error Deleting Marks");
        }
    }
}