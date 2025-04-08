package com.example.marketAplication.infraestructure.mapper;

import com.example.marketAplication.domain.dto.PagoDTO;
import com.example.marketAplication.infraestructure.entity.Pago;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PagoMapper {
    
    public PagoDTO toPagoDTO(Pago pago) {
        if (pago == null) {
            return null;
        }
        
        PagoDTO dto = new PagoDTO();
        dto.setId(pago.getId());
        dto.setFechaPago(pago.getFechaPago());
        dto.setMonto(pago.getMonto());
        dto.setMetodo(pago.getMetodo());
        dto.setEstado(pago.getEstado());
        
        if (pago.getOrden() != null) {
            dto.setOrdenId(pago.getOrden().getId());
        }
        
        return dto;
    }
    
    public List<PagoDTO> toPagoDTOs(List<Pago> pagos) {
        if (pagos == null) {
            return null;
        }
        
        List<PagoDTO> dtos = new ArrayList<>(pagos.size());
        for (Pago pago : pagos) {
            dtos.add(toPagoDTO(pago));
        }
        
        return dtos;
    }
    
    public Pago toPago(PagoDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Pago pago = new Pago();
        pago.setId(dto.getId());
        pago.setFechaPago(dto.getFechaPago());
        pago.setMonto(dto.getMonto());
        pago.setMetodo(dto.getMetodo());
        pago.setEstado(dto.getEstado());
        
        return pago;
    }
}