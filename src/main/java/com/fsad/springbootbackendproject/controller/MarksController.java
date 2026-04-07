package com.fsad.springbootbackendproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fsad.springbootbackendproject.entity.Mark;
import com.fsad.springbootbackendproject.entity.Student;
import com.fsad.springbootbackendproject.service.MarkService;

@RestController
@RequestMapping("/marksapi")
@CrossOrigin("*")
public class MarksController {

    @Autowired
    private MarkService service;

    @PostMapping("/{studentId}")
    public Student addMarks(@PathVariable Long studentId, @RequestBody Mark mark) {
        return service.addMarks(studentId, mark);
    }
}