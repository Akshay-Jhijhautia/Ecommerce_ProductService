package com.akshay.productservice.controllers;

import com.akshay.productservice.dtos.ExceptionDto;
import com.akshay.productservice.exceptions.ProductNotFoundException;
import com.akshay.productservice.models.Product;
import com.akshay.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    ExceptionDto exceptionDto = new ExceptionDto();

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        exceptionDto.setId(id);
        return new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );
    }

    @GetMapping()
    public ResponseEntity<List<Product>>  getAllProducts() {
        return new ResponseEntity<>(
                productService.getAllProducts(),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long productId,@RequestBody Product product) {
        return new ResponseEntity<>(
                productService.updateProduct(productId,product),
                HttpStatus.PARTIAL_CONTENT
        );
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long productId,@RequestBody Product product) {
        return product;
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticExceptions() {
        exceptionDto.setMessage("Arithmetic Exception Has Occurred");
        exceptionDto.setSolution("Please try again later");

        return new ResponseEntity<>(
                exceptionDto,
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException() {
        exceptionDto.setMessage("Product Not Found");
        exceptionDto.setSolution("Please Try again with valid Id");

        return new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_REQUEST
        );
    }
}
