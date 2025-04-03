package com.example.marketAplication.domain.repository;

import java.util.List;

import com.example.marketAplication.domain.dto.ProductDTO;

public interface IProduct {
    
    List<ProductDTO> getAll();

}
