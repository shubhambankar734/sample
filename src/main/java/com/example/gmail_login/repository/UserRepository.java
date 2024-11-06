package com.example.gmail_login.repository;

import com.example.gmail_login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameAndPassword(String username, String password);
    User findByName(String username);
}