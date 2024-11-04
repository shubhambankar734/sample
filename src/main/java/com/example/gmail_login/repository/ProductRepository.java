package com.example.gmail_login.repository;

import com.example.gmail_login.model.Product;
import com.example.gmail_login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
