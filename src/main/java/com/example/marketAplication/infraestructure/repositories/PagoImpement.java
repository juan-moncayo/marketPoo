package com.example.marketAplication.infraestructure.repositories;

import com.example.marketAplication.domain.dto.PagoDTO;
import com.example.marketAplication.infraestructure.entity.Orden;
import com.example.marketAplication.infraestructure.entity.Pago;
import com.example.marketAplication.domain.repository.IPago;
import com.example.marketAplication.infraestructure.crud.OrdenRepository;
import com.example.marketAplication.infraestructure.crud.PagoRepository;
import com.example.marketAplication.infraestructure.mapper.PagoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class PagoImpement implements IPago {
    
    private final PagoRepository pagoRepository;
    private final OrdenRepository ordenRepository;
    private final PagoMapper mapper;
    
    @Autowired
    public PagoImpement(PagoRepository pagoRepository, OrdenRepository ordenRepository, PagoMapper mapper) {
        this.pagoRepository = pagoRepository;
        this.ordenRepository = ordenRepository;
        this.mapper = mapper;
    }
    
    @Override
    public List<PagoDTO> findAll() {
        return mapper.toPagoDTOs(pagoRepository.findAll());
    }
    
    @Override
    public Optional<PagoDTO> findById(Long id) {
        return pagoRepository.findById(id)
                .map(mapper::toPagoDTO);
    }
    
    @Override
    public PagoDTO save(PagoDTO pagoDTO) {
        Pago pago = mapper.toPago(pagoDTO);
        Optional<Orden> orden = ordenRepository.findById(pagoDTO.getOrdenId());
        
        if (orden.isPresent()) {
            pago.setOrden(orden.get());
            return mapper.toPagoDTO(pagoRepository.save(pago));
        }
        
        return null;
    }
    
    @Override
    public void update(PagoDTO pagoDTO) {
        Pago pago = mapper.toPago(pagoDTO);
        Optional<Orden> orden = ordenRepository.findById(pagoDTO.getOrdenId());
        
        if (orden.isPresent()) {
            pago.setOrden(orden.get());
            pagoRepository.save(pago);
        }
    }
    
    @Override
    public void deleteById(Long id) {
        pagoRepository.deleteById(id);
    }
    
    @Override
    public List<PagoDTO> findByOrdenId(Long ordenId) {
        return mapper.toPagoDTOs(pagoRepository.findByOrdenId(ordenId));
    }
}
