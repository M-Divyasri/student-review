package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    @PostMapping("/review")
    public String handleReview(@RequestParam String name,
            @RequestParam String email,
            @RequestParam String course,
            @RequestParam String rating,
            @RequestParam String message) {
        System.out.println("Name: " + name + ", Email: " + email + ", Course: " + course + ", Rating: " + rating
                + ", Message: " + message);
        return "Form submitted successfully!😄";
    }
}
