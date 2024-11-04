package com.example.gmail_login.service;
import com.example.gmail_login.model.CartItem;
import com.example.gmail_login.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItem getCartItemById(Long id) {
        return cartItemRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cart item not found"));
    }

    public CartItem createCartItem(CartItem cartItem) {
        // Perform any necessary validations or business logic
        return cartItemRepository.save(cartItem);
    }

    public CartItem updateCartItem(Long id, CartItem cartItem) {
        CartItem existingCartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cart item not found"));

        // Update the attributes of the existing cart item
        existingCartItem.setProductId(cartItem.getProductId());
        existingCartItem.setQuantity(cartItem.getQuantity());
        existingCartItem.setUpdatedAt(LocalDateTime.now());

        return cartItemRepository.save(existingCartItem);
    }

    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }
}
