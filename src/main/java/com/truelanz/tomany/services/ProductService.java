package com.truelanz.tomany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.truelanz.tomany.dto.CategoryDTO;
import com.truelanz.tomany.dto.ProductCategoryDTO;
import com.truelanz.tomany.entities.Category;
import com.truelanz.tomany.entities.Product;
import com.truelanz.tomany.repositories.CategoryRepository;
import com.truelanz.tomany.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<ProductCategoryDTO> findAll() {
        List<Product> result = productRepository.findAll();
        return result.stream().map(x -> new ProductCategoryDTO(x)).toList();
    }

    @Transactional
    public ProductCategoryDTO insert(ProductCategoryDTO dto) {

        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());

        for(CategoryDTO catDto : dto.getCategories()) {
            Category cat = categoryRepository.getReferenceById(catDto.getId());

            //Category cat = new Category();
            //cat.setId(catDto.getId());
            entity.getCategories().add(cat);
        }

        entity = productRepository.save(entity);
        return new ProductCategoryDTO(entity);

       
    }
    
}
