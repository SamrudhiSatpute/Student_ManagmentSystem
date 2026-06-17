package com.project.StudentMS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.StudentMS.model.Student;



@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public StudentService() {
        students.add(new Student(1, "Sam"));
        students.add(new Student(2, "Rahul"));
    }

    public List<Student> getStudents() {
        return students;
    }

    
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }
       
}