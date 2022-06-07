package com.ironhack.productsapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

enum Status {
    ON_STOCK, AWAITING, EXPIRED;
}

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Name of the product cannot be empty")
    private String productName;
    @Digits(integer = 4, fraction = 2, message = "Price can't be higher than 9999 and only accept two digits")
    private double price;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)// 2022-01-05
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date expirationDate;
    @Enumerated
    @NotNull
    private Status status;

    public Product() {
    }


    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
