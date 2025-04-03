package com.example.marketAplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.marketAplication.domain.dto.ProductDTO;
import com.example.marketAplication.domain.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/productos")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> obtenerProductos() {
        return productService.getAllProducts();
    }


       /*  return productRepository.findAll()
            .stream().map(producto -> productoMapper.toProductDTO(producto)).collect(Collectors.toList());
            */
    
                    
                
}
