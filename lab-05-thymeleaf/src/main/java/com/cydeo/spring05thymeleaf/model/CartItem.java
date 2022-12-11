package com.cydeo.spring05thymeleaf.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private Product product;
    private Integer quantity;
    private BigDecimal totalAmount;
}
