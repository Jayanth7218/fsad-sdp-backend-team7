package com.fsad.springbootbackendproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsad.springbootbackendproject.entity.Mark;
import com.fsad.springbootbackendproject.entity.Student;
import com.fsad.springbootbackendproject.repository.StudentRepository;

@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    private StudentRepository repo;

    @Override
    public Student addMarks(Long studentId, Mark mark) {
        Student student = repo.findById(studentId).orElse(null);

        if (student != null) {
            student.getMarks().add(mark);
            return repo.save(student);
        }

        return null;
    }
}