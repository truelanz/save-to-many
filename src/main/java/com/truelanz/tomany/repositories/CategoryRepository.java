package com.truelanz.tomany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truelanz.tomany.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
