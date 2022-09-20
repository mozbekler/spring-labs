package com.cydeo.lab04springmvc.repository;

import com.cydeo.lab04springmvc.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    boolean save(Product product);

    Product findProductById(UUID productId);

    List<Product> findAll();
}
