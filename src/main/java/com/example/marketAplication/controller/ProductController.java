package com.example.marketAplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.marketAplication.domain.dto.ProductDTO;
import com.example.marketAplication.infraestructure.crud.ProductRepository;
import com.example.marketAplication.infraestructure.entity.Producto;
import com.example.marketAplication.infraestructure.mapper.ProductoMapper;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/productos")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductoMapper productoMapper;

    @GetMapping
    public List<ProductDTO> obtenerProductos() {

        List<Producto> producto = productRepository.findAll();
        return productoMapper.toProductDTOs(producto);

       /*  return productRepository.findAll()
            .stream().map(producto -> productoMapper.toProductDTO(producto)).collect(Collectors.toList());
            */
    
                    
                
}


}
