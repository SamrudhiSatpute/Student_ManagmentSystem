package com.project.StudentMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.StudentMS.model.Student;

public interface StudentRepository
        extends JpaRepository<Student, Integer> {

}
