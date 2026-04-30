package com.klef.fsad.springbootbackendproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.klef.fsad.springbootbackendproject.entity.*;
import com.klef.fsad.springbootbackendproject.repository.FacultyRepository;
import com.klef.fsad.springbootbackendproject.repository.MarksRepository;
import com.klef.fsad.springbootbackendproject.repository.StudentRepository;
import com.klef.fsad.springbootbackendproject.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addFaculty(Faculty faculty) {
        try {
            // 🔐 Encrypt password
            faculty.setPassword(passwordEncoder.encode(faculty.getPassword()));

            facultyRepository.save(faculty);

            return "Faculty Added Successfully";
        } catch (Exception e) {
            return "Error Adding Faculty";
        }
    }
    @Override
    public String deleteFaculty(int id) {
        facultyRepository.deleteById(id);
        return "Faculty Deleted Successfully";
    }
    @Override
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }
    
    
    @Override
    public Faculty verifyFacultyLogin(String email, String password) {
        return facultyRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public String addSubject(Subject subject) {
        subjectRepository.save(subject);
        return "Subject Added Successfully";
    }

    @Override
    public List<Subject> getSubjectsByFaculty(int facultyId) {
        return subjectRepository.findByFaculty_Id(facultyId);
    }

    @Override
    public String deleteSubject(int id) {
        subjectRepository.deleteById(id);
        return "Subject Deleted Successfully";
    }

    @Override
    public String addMarks(Marks marks) {
        try {
            
            if (marks == null || marks.getStudent() == null || marks.getSubject() == null) {
                throw new RuntimeException("Invalid payload: student/subject missing");
            }

            int studentId = marks.getStudent().getId();
            int subjectId = marks.getSubject().getId();

            if (studentId <= 0 || subjectId <= 0) {
                throw new RuntimeException("Invalid IDs: studentId=" + studentId + ", subjectId=" + subjectId);
            }

            Student student = studentRepository.findById(studentId)
                    .orElseThrow(() -> new RuntimeException("Student not found: " + studentId));

            Subject subject = subjectRepository.findById(subjectId)
                    .orElseThrow(() -> new RuntimeException("Subject not found: " + subjectId));

            marks.setStudent(student);
            marks.setSubject(subject);

            if (marks.getMaxMarks() <= 0) {
                marks.setMaxMarks(100);
            }

            marksRepository.save(marks);

            return "Marks Added Successfully";
        } catch (Exception e) {
       
            e.printStackTrace();
            return "Error Adding Marks: " + e.getMessage();
        }
    }

    @Override
    public String updateMarks(int id, int marksObtained) {
        Optional<Marks> optionalMarks = marksRepository.findById(id);

        if (optionalMarks.isPresent()) 
        {
        	
            Marks marks = optionalMarks.get();
            
            marks.setMarksObtained(marksObtained);
            
            marksRepository.save(marks);
            
            return "Marks Updated Successfully";
        } 
        else 
        {
        	
            return "Marks ID Not Found";
        }
    }

    @Override
    public List<Marks> getMarksBySubject(int subjectId) 
    {
    	
        return marksRepository.findBySubject_Id(subjectId);
    }
    
    
    @Override
    public List<Marks> getAllMarks()
    {
    	
        return marksRepository.findAll();
    
    }
    
    @Override
    public String deleteMarks(int id)
    {
    	
    	marksRepository.deleteById(id);
        
    	return "Marks Deleted Successfully";
    }
    
    @Override
    public Faculty getFacultyByEmail(String email) 
    {
        return facultyRepository.findByEmail(email);
    }
    
    @Override
    public String deleteStudent(int id) {
        studentRepository.deleteById(id);
        return "Student Deleted Successfully";
    }
    
    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
    
}