package com.example.marketAplication.domain.service;

import com.example.marketAplication.domain.dto.PagoDTO;
import com.example.marketAplication.domain.repository.IPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PagoService {
    
    private final IPago pagoRepository;
    
    @Autowired
    public PagoService(IPago pagoRepository) {
        this.pagoRepository = pagoRepository;
    }
    
    public List<PagoDTO> getAll() {
        return pagoRepository.findAll();
    }
    
    public Optional<PagoDTO> getPago(Long pagoId) {
        return pagoRepository.findById(pagoId);
    }
    
    public PagoDTO save(PagoDTO pago) {
        return pagoRepository.save(pago);
    }
    
    public boolean update(PagoDTO pago) {
        if (pagoRepository.findById(pago.getId()).isPresent()) {
            pagoRepository.update(pago);
            return true;
        }
        return false;
    }
    
    public boolean delete(Long pagoId) {
        if (pagoRepository.findById(pagoId).isPresent()) {
            pagoRepository.deleteById(pagoId);
            return true;
        }
        return false;
    }
    
    public List<PagoDTO> getByOrden(Long ordenId) {
        return pagoRepository.findByOrdenId(ordenId);
    }
}