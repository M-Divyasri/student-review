package com.example.demo.controller;

import com.example.demo.entity.Review;
import com.example.demo.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @PostMapping("/review")
    public String handleReview(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String course,
            @RequestParam int rating,
            @RequestParam String message) {

        Review review = new Review();
        review.setName(name);
        review.setEmail(email);
        review.setCourse(course);
        review.setRating(rating);
        review.setMessage(message);

        reviewRepository.save(review);

        return "Review submitted successfully! 😄";
    }

    // NEW endpoint for Task-2 requirement
    @GetMapping("/reviews")
    public java.util.List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}
