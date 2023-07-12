package com.truelanz.tomany.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.truelanz.tomany.dto.ProductCategoryDTO;
import com.truelanz.tomany.services.ProductService;

@RequestMapping(value = "/products")
@RestController
public class ProductController {
    
    @Autowired
    private ProductService service;

    @GetMapping
    public List<ProductCategoryDTO> findAll() {
        return service.findAll();
    }
    
    @PostMapping
    public ResponseEntity<ProductCategoryDTO> insert(@RequestBody ProductCategoryDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    

}
