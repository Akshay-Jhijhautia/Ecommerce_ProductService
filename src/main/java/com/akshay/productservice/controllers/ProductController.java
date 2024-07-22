package com.akshay.productservice.controllers;

import com.akshay.productservice.models.Product;
import com.akshay.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {

    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long productId,@RequestBody Product product) {
        return productService.updateProduct(productId,product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long productId,@RequestBody Product product) {
        return product;
    }
}
