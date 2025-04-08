package com.example.marketAplication.infraestructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.marketAplication.domain.dto.ProductDTO;
import com.example.marketAplication.domain.repository.IProduct;
import com.example.marketAplication.infraestructure.crud.ProductRepository;
import com.example.marketAplication.infraestructure.entity.Producto;
import com.example.marketAplication.infraestructure.mapper.ProductoMapper;

@Repository
public class ProductoImpement implements IProduct {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public List<ProductDTO> getAll() {
        List<Producto> productos = productRepository.findAll();
        return productoMapper.toProductDTOs(productos);
    }
    
    @Override
    public void save(ProductDTO productDTO) {
        Producto producto = productoMapper.toProducto(productDTO);
        productRepository.save(producto);
    }
}
