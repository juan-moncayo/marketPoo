package com.example.marketAplication.infraestructure.mapper;

import com.example.marketAplication.domain.dto.OrdenItemDTO;
import com.example.marketAplication.infraestructure.entity.OrdenItem;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrdenItemMapper {
    
    public OrdenItemDTO toOrdenItemDTO(OrdenItem ordenItem) {
        if (ordenItem == null) {
            return null;
        }
        
        OrdenItemDTO dto = new OrdenItemDTO();
        dto.setId(ordenItem.getId());
        dto.setCantidad(ordenItem.getCantidad());
        dto.setPrecioUnitario(ordenItem.getPrecioUnitario());
        
        if (ordenItem.getProducto() != null) {
            dto.setProductoId(ordenItem.getProducto().getId());
        }
        
        if (ordenItem.getOrden() != null) {
            dto.setOrdenId(ordenItem.getOrden().getId());
        }
        
        return dto;
    }
    
    public List<OrdenItemDTO> toOrdenItemDTOs(List<OrdenItem> ordenItems) {
        if (ordenItems == null) {
            return null;
        }
        
        List<OrdenItemDTO> dtos = new ArrayList<>(ordenItems.size());
        for (OrdenItem ordenItem : ordenItems) {
            dtos.add(toOrdenItemDTO(ordenItem));
        }
        
        return dtos;
    }
    
    public OrdenItem toOrdenItem(OrdenItemDTO dto) {
        if (dto == null) {
            return null;
        }
        
        OrdenItem ordenItem = new OrdenItem();
        ordenItem.setId(dto.getId());
        ordenItem.setCantidad(dto.getCantidad());
        ordenItem.setPrecioUnitario(dto.getPrecioUnitario());
        
        return ordenItem;
    }
}

