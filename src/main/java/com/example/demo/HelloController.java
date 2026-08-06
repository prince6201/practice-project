package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello! This project is ready for you to add Swagger.";
    }

    @GetMapping("/api/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

}
