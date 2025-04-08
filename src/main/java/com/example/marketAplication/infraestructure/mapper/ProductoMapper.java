package com.example.marketAplication.infraestructure.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.marketAplication.domain.dto.ProductDTO;
import com.example.marketAplication.infraestructure.entity.Producto;

@Component
public class ProductoMapper {
    
    public ProductDTO toProductDTO(Producto producto) {
        if (producto == null) {
            return null;
        }
        
        ProductDTO dto = new ProductDTO();
        dto.setId(producto.getId());
        dto.setName(producto.getNombre());
        dto.setDescription(producto.getDescripcion());
        dto.setPrice(producto.getPrecio().doubleValue());
        dto.setStock(producto.getStock());
        
        return dto;
    }
    
    public List<ProductDTO> toProductDTOs(List<Producto> productos) {
        if (productos == null) {
            return null;
        }
        
        List<ProductDTO> dtos = new ArrayList<>(productos.size());
        for (Producto producto : productos) {
            dtos.add(toProductDTO(producto));
        }
        
        return dtos;
    }
    
    public Producto toProducto(ProductDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Producto producto = new Producto();
        producto.setId(dto.getId());
        producto.setNombre(dto.getName());
        producto.setDescripcion(dto.getDescription());
        producto.setPrecio(java.math.BigDecimal.valueOf(dto.getPrice()));
        producto.setStock(dto.getStock());
        
        return producto;
    }
}

