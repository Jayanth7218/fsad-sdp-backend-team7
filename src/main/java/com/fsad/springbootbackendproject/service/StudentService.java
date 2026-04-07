package com.fsad.springbootbackendproject.service;

import com.fsad.springbootbackendproject.entity.Student;
import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudents();

    void deleteStudent(Long id);

    Student getStudentById(Long id);
}