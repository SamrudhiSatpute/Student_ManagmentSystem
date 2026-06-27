package com.project.StudentMS.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.StudentMS.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}