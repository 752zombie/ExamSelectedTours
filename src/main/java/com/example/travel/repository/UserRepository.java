package com.example.travel.repository;

import com.example.travel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByFirstNameAndPassword(String firstName, String password);




}
