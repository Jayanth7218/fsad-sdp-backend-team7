package com.fsad.springbootbackendproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsad.springbootbackendproject.entity.*;
import com.fsad.springbootbackendproject.entity.Faculty;
import com.fsad.springbootbackendproject.entity.Marks;
import com.fsad.springbootbackendproject.entity.Subject;
import com.fsad.springbootbackendproject.repository.FacultyRepository;
import com.fsad.springbootbackendproject.repository.MarksRepository;
import com.fsad.springbootbackendproject.repository.StudentRepository;
import com.fsad.springbootbackendproject.repository.SubjectRepository;

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
        int studentId = marks.getStudent().getId();
        int subjectId = marks.getSubject().getId();

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        marks.setStudent(student);
        marks.setSubject(subject);

        marksRepository.save(marks);
        return "Marks Added Successfully";
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
}