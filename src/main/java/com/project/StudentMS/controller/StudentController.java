package com.project.StudentMS.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.StudentMS.model.Student;
import com.project.StudentMS.service.StudentService;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

   @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
        
    }
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
    return studentService.addStudent(student);
}
    }