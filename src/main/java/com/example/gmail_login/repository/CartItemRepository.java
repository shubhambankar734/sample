package com.example.gmail_login.repository;

import com.example.gmail_login.model.CartItem;
import com.example.gmail_login.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
