package com.example.marketAplication.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.marketAplication.domain.dto.ProductDTO;
import com.example.marketAplication.domain.repository.IProduct;

@Service
public class ProductService {
    
    @Autowired
    private IProduct productRepository;
    
    public List<ProductDTO> getAllProducts() {
        return productRepository.getAll();
    }
    
    public Optional<ProductDTO> getProduct(Long id) {
        return productRepository.getById(id);
    }
    
    public ProductDTO saveProduct(ProductDTO productDTO) {
        return productRepository.save(productDTO);
    }
    
    public boolean updateProduct(ProductDTO productDTO) {
        if (productRepository.getById(productDTO.getId()).isPresent()) {
            productRepository.update(productDTO);
            return true;
        }
        return false;
    }
    
    public boolean deleteProduct(Long id) {
        if (productRepository.getById(id).isPresent()) {
            productRepository.delete(id);
            return true;
        }
        return false;
    }
}

