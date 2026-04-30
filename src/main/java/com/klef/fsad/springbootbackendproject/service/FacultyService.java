package com.klef.fsad.springbootbackendproject.service;

import java.util.List;

import com.klef.fsad.springbootbackendproject.entity.*;

public interface FacultyService {
	
	
    public Faculty verifyFacultyLogin(String email, String password);
    
    Faculty getFacultyByEmail(String email);
    
    public String addSubject(Subject subject);
    
    

    public List<Subject> getSubjectsByFaculty(int facultyId);
    
    public String deleteSubject(int id);

    public String addMarks(Marks marks);
    
    public String updateMarks(int id, int marksObtained);
    
    public List<Marks> getMarksBySubject(int subjectId);
    
    List<Marks> getAllMarks();
    
    String addFaculty(Faculty faculty);
    List<Faculty> getAllFaculty();
    String deleteFaculty(int id);
    
    String deleteStudent(int id);
    List<Subject> getAllSubjects();
    String deleteMarks(int id);
    
}