package com.klef.fsad.springbootbackendproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsad.springbootbackendproject.entity.Marks;
import com.klef.fsad.springbootbackendproject.entity.Student;
import com.klef.fsad.springbootbackendproject.entity.Subject;
import com.klef.fsad.springbootbackendproject.repository.MarksRepository;
import com.klef.fsad.springbootbackendproject.repository.StudentRepository;
import com.klef.fsad.springbootbackendproject.repository.SubjectRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private MarksRepository marksRepository;

    @Override
    public Student verifyStudentLogin(String email, String password) {
        return studentRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public List<Marks> getMarksByStudent(int studentId) {
        return marksRepository.findByStudent_Id(studentId);
    }

    @Override
    public String studentRegistration(Student student) {
        studentRepository.save(student);
        return "Student Registered Successfully";
    }
}