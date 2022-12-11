package com.cydeo.spring05thymeleaf.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private BigDecimal cartTotalAmount;
    private List<CartItem> cartItemList;

}
