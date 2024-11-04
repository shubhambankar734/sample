package com.example.gmail_login.repository;

import com.example.gmail_login.model.CartItem;
import com.example.gmail_login.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
