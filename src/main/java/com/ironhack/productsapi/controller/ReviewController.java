package com.ironhack.productsapi.controller;

import com.ironhack.productsapi.dto.ReviewDTO;
import com.ironhack.productsapi.model.Product;
import com.ironhack.productsapi.model.Review;
import com.ironhack.productsapi.repository.ProductRepository;
import com.ironhack.productsapi.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/reviews/get-all")
    public List<Review> showAllReviews() {
        return reviewRepository.findAll();
    }

    @PostMapping("/reviews/add-review")
    public Review addReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @PostMapping("products/{id}/add-review")
    public Review addReview(@PathVariable long id, @RequestBody ReviewDTO reviewDTO) {
        Product product;

        if (!productRepository.findById(id).isPresent()) {
            product = new Product();
        } else {
            product = productRepository.findById(id).get();

        }

        Review review = new Review(reviewDTO.getReview(), product);

        return reviewRepository.save(review);
    }
    @PutMapping("products/product/replace-review/{id}")
    public Review putReview(@PathVariable long id, @RequestBody ReviewDTO reviewDTO){
        Review review = reviewRepository.findById(id).get();
        review.setReview(reviewDTO.getReview());
        return reviewRepository.save(review);
    }

    @DeleteMapping("/products/product/reviews/delete-review/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  void deleteReview(@PathVariable long id){
        reviewRepository.deleteById(id);
    }




}
