package com.example.marketAplication.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.marketAplication.domain.dto.ProductDTO;

public interface IProduct {
    
    List<ProductDTO> getAll();
   

    Optional<ProductDTO> getById(Long id);
    
    ProductDTO save(ProductDTO productDTO);
    
    void update(ProductDTO productDTO);
    
    void delete(Long id);
}

