package com.truelanz.tomany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truelanz.tomany.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
