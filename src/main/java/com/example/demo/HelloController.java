package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/api/bye")
    public String bye() {
        return "Goodbye!";
    }

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        // In a real app you'd save this to a database.
        // For now, we just return the same user back to confirm it was received.
        return user;
    }

    // Simple data model for the request/response body above.
    public static class User {
        private String name;
        private String email;

        public User() {
        }

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
