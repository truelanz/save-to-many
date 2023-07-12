package com.truelanz.tomany.dto;

import com.truelanz.tomany.entities.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO(Category entity) {
        id = entity.getId();
        name = entity.getName();
    }

    
    
}
