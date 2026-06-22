package com.project.StudentMS.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.StudentMS.model.Student;
import com.project.StudentMS.service.StudentService;

import jakarta.validation.Valid;


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
    public Student addStudent(
            @Valid @RequestBody Student student) {

        return studentService.addStudent(student);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(
        @PathVariable int id) {

    return studentService.getStudentById(id);
}

@DeleteMapping("/student/{id}")
public String deleteStudent(
        @PathVariable int id) {

    studentService.deleteStudent(id);

    return "Deleted";
}

@PutMapping("/student/{id}")
public Student updateStudent(
        @PathVariable int id,
        @Valid @RequestBody Student student) {

    return studentService.updateStudent(id, student);
}
    }