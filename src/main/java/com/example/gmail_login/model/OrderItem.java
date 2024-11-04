package com.example.gmail_login.model;
import com.example.gmail_login.model.Product;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long orderId;


    private Long productId;

    private int quantity;

    private BigDecimal price;

    // Constructors, getters, and setters
}
