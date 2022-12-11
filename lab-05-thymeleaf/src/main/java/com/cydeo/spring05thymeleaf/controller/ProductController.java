package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")     //localhost 8080/product/create-product
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create-product")
    public String createProduct(Model model){

        model.addAttribute("product",new Product());

        return "product/create-product";
    }

    @PostMapping("/create-product")
    public String createProduct2(@ModelAttribute("product") Product product){

        productService.productCreate(product);


        return "redirect:/product/list";
    }

    @GetMapping("/list")
    public String list( Model model){

        model.addAttribute("list",productService.listProduct());

        return "product/list";

    }



}
