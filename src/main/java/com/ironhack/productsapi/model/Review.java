package com.ironhack.productsapi.model;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String review;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Review() {
    }

    public Review(String review, Product product) {
        this.review = review;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public String getReview() {
        return review;
    }

    public Product getProduct() {
        return product;
    }
}
