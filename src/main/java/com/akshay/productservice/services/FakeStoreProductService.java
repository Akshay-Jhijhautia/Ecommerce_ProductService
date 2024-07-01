package com.akshay.productservice.services;

import com.akshay.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) {
        restTemplate.getForObject("https://fakestoreapi.com" + id,);
        return new Product();
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }
}
