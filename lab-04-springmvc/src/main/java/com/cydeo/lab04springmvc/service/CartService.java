package com.cydeo.lab04springmvc.service;

import com.cydeo.lab04springmvc.model.Cart;

import java.util.UUID;

public interface CartService {
    Cart addToCart(UUID productId, Integer quantity);
    boolean deleteFromCart(UUID productId);
}
