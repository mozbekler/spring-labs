package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

import static com.cydeo.spring05thymeleaf.service.impl.CartServiceImpl.CART;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping("/show-cart")
    public String showCart(Model model){

        model.addAttribute("cart", CART);

        return "/cart/show-cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id){

        cartService.deleteFromCart(UUID.fromString(id));

        return "redirect:/cart/show-cart";
    }

    @GetMapping("/add/{id}")
    public String addProductToCart(@PathVariable("id") String id){

        cartService.addToCart(UUID.fromString(id),1);

        return "redirect:/product/list";

    }














}
