package com.truelanz.tomany.dto;

import java.util.ArrayList;
import java.util.List;

import com.truelanz.tomany.entities.Category;
import com.truelanz.tomany.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductCategoryDTO {

    private Long id;
    private String name;
    private Double price;
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductCategoryDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        for(Category cat : entity.getCategories()) {
            categories.add(new CategoryDTO(cat));
        }
    }
    
    
    
}
