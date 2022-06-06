package com.ironhack.productsapi.controller;

import com.ironhack.productsapi.model.Product;
import com.ironhack.productsapi.repository.ProductRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/show-products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> showAllProducts() {
        return productRepository.findAll();
    }


    @GetMapping("/find-product/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    // ESTO es lo mismo: @RequestMapping(value = "/find-product/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable long id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @GetMapping("find-product/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Product findByName(@PathVariable String name) {

        if (productRepository.findByProductName(name).isPresent()) {
            return productRepository.findByProductName(name).get();
        } else {
            return null;
        }
    }

    @GetMapping("find-product/price/")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findByPriceRange(@RequestParam Optional<Double> min, @RequestParam @NotNull double max) {
        double min1;
        double max1 = max;

        if (!min.isPresent()) {
            min1 = 0;
        } else {
            min1 = min.get();
        }



        return productRepository.findByPriceBetween(min1, max1);

    }


}
