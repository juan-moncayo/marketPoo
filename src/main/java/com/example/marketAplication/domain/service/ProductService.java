package com.example.marketAplication.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.marketAplication.domain.dto.ProductDTO;
import com.example.marketAplication.infraestructure.repositories.ProductoImpement;

@Service
public class ProductService {

    @Autowired
    private ProductoImpement productoImpement;

    public List<ProductDTO> getAll() {
        return productoImpement.getAll();
    }

    public List<ProductDTO> getAllProducts() {
        throw new UnsupportedOperationException("Obetner productos");
    }
    
}
