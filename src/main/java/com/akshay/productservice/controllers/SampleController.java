package com.akshay.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

// @Rest Controller means that this class will be hosting a set of HTTP API's
@RestController
@RequestMapping("/say")
public class SampleController {

    @GetMapping("/hello/{name}/{times}")
    public String[] sayHello(@PathVariable("name") String name,
                             @PathVariable("times") int times) {
        String[] result = new String[times];
        Arrays.fill(result, name);
        return result;
    }

    @GetMapping("/cool")
    public String cool(){
        return "Welcome to Spring Boot";
    }
}
