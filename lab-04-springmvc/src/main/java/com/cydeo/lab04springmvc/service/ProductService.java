package com.cydeo.lab04springmvc.service;

import com.cydeo.lab04springmvc.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    boolean productCreate(Product product);
    List<Product> listProduct();
    Product findProductById(UUID uuid);
}
