package com.example.marketAplication.infraestructure.mapper;

import com.example.marketAplication.domain.dto.OrdenDTO;
import com.example.marketAplication.domain.dto.OrdenItemDTO;
import com.example.marketAplication.infraestructure.entity.Orden;
import com.example.marketAplication.infraestructure.entity.OrdenItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrdenMapper {
    
    @Autowired
    private OrdenItemMapper ordenItemMapper;
    
    public OrdenDTO toOrdenDTO(Orden orden) {
        if (orden == null) {
            return null;
        }
        
        OrdenDTO dto = new OrdenDTO();
        dto.setId(orden.getId());
        dto.setFecha(orden.getFecha());
        dto.setTotal(orden.getTotal());
        dto.setEstado(orden.getEstado());
        
        if (orden.getCliente() != null) {
            dto.setClienteId(orden.getCliente().getId());
        }
        
        if (orden.getItems() != null) {
            List<OrdenItemDTO> itemDTOs = new ArrayList<>();
            
            for (OrdenItem item : orden.getItems()) {
                itemDTOs.add(ordenItemMapper.toOrdenItemDTO(item));
            }
            dto.setItems(itemDTOs);
        }
        
        return dto;
    }
    
    public List<OrdenDTO> toOrdenDTOs(List<Orden> ordenes) {
        if (ordenes == null) {
            return null;
        }
        
        List<OrdenDTO> dtos = new ArrayList<>(ordenes.size());
        for (Orden orden : ordenes) {
            dtos.add(toOrdenDTO(orden));
        }
        
        return dtos;
    }
    
    public Orden toOrden(OrdenDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Orden orden = new Orden();
        orden.setId(dto.getId());
        orden.setFecha(dto.getFecha());
        orden.setTotal(dto.getTotal());
        orden.setEstado(dto.getEstado());
        
        return orden;
    }
}