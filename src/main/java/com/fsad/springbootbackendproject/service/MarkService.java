package com.fsad.springbootbackendproject.service;

import com.fsad.springbootbackendproject.entity.Mark;
import com.fsad.springbootbackendproject.entity.Student;

public interface MarkService {

    Student addMarks(Long studentId, Mark mark);
}