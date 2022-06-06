package com.ironhack.productsapi.repository;

import com.ironhack.productsapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByProductName(String productName);
    List<Product> findByPriceBetween(double min, double max);

}
