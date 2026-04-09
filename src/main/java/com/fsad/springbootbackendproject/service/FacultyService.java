package com.fsad.springbootbackendproject.service;

import com.fsad.springbootbackendproject.entity.*;
import com.fsad.springbootbackendproject.entity.*;
import java.util.List;

public interface FacultyService {
	
	
    public Faculty verifyFacultyLogin(String email, String password);
    
    public String addSubject(Subject subject);
    
    

    public List<Subject> getSubjectsByFaculty(int facultyId);
    
    public String deleteSubject(int id);

    public String addMarks(Marks marks);
    
    public String updateMarks(int id, int marksObtained);
    
    public List<Marks> getMarksBySubject(int subjectId);
    
    List<Marks> getAllMarks();
    
    String deleteMarks(int id);
    
}