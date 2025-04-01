package com.example.marketAplication.infraestructure.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.marketAplication.domain.dto.ProductDTO;
import com.example.marketAplication.infraestructure.entity.Producto;

    
@Mapper(componentModel = "spring")
public interface ProductoMapper {

        @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "precio", target = "price"),
        })
        ProductDTO toProductDTO(Producto producto);
        List<ProductDTO> toProductDTOs(List<Producto> productos);


        
        @InheritInverseConfiguration
        Producto toProducto(ProductDTO productDTO);
        List<Producto> toProductos(List<ProductDTO> productDTOs);


}
