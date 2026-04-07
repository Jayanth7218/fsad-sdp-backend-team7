package com.fsad.springbootbackendproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsad.springbootbackendproject.entity.Student;
import com.fsad.springbootbackendproject.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repo;

    @Override
    public Student addStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }
}