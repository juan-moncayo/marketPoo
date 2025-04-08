package com.example.marketAplication.infraestructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.marketAplication.domain.dto.ProductDTO;
import com.example.marketAplication.domain.repository.IProduct;
import com.example.marketAplication.infraestructure.crud.ProductRepository;
import com.example.marketAplication.infraestructure.mapper.ProductoMapper;

@Repository
public class ProductoImplement implements IProduct {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductoMapper mapper;
    
    @Override
    public List<ProductDTO> getAll() {
        return mapper.toProductDTOs(productRepository.findAll());
    }

    @Override
    public Optional<ProductDTO> getById(Long id) {
        return productRepository.findById(id)
                .map(producto -> mapper.toProductDTO(producto));
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return mapper.toProductDTO(
                productRepository.save(
                        mapper.toProducto(productDTO)
                )
        );
    }

    @Override
    public void update(ProductDTO productDTO) {
        productRepository.save(mapper.toProducto(productDTO));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}

