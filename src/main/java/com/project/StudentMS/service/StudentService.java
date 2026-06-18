package com.project.StudentMS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.StudentMS.model.Student;
import com.project.StudentMS.repository.StudentRepository;



// @Service
// public class StudentService {

//     private List<Student> students = new ArrayList<>();

//     public StudentService() {
//         students.add(new Student(1, "Sam"));
//         students.add(new Student(2, "Rahul"));
//     }

//     public List<Student> getStudents() {
//         return students;
//     }

    
//     public Student addStudent(Student student) {
//         students.add(student);
//         return student;
//     }
       
// }
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }


    public Student getStudentById(int id) {
    return studentRepository.findById(id).orElse(null);


}

        public void deleteStudent(int id) {
    studentRepository.deleteById(id);
}
}