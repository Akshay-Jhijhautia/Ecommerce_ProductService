package com.akshay.productservice.services;

import com.akshay.productservice.exceptions.ProductNotFoundException;
import com.akshay.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product updateProduct(Long productId, Product product);

    Product replaceProduct(Long productId, Product product);

    void deleteProduct(Long productId);
}
