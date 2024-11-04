package com.example.gmail_login.model;


import lombok.Data;

import javax.persistence.*;

@Table(name = "USERS")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;
    private Role role;
    private String createdAt;
    private String updatedAt;
}

