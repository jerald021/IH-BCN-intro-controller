package com.ironhack.productsapi.dto;

public class ReviewDTO {

    String review;

    public ReviewDTO(String review) {
        this.review = review;
    }

    public ReviewDTO() {
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
