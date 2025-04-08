package com.example.marketAplication.domain.service;

import com.example.marketAplication.domain.dto.OrdenDTO;
import com.example.marketAplication.domain.repository.IOrden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {
    
    private final IOrden ordenRepository;
    
    @Autowired
    public OrdenService(IOrden ordenRepository) {
        this.ordenRepository = ordenRepository;
    }
    
    public List<OrdenDTO> getAll() {
        return ordenRepository.findAll();
    }
    
    public Optional<OrdenDTO> getOrden(Long ordenId) {
        return ordenRepository.findById(ordenId);
    }
    
    public OrdenDTO save(OrdenDTO orden) {
        return ordenRepository.save(orden);
    }
    
    public boolean update(OrdenDTO orden) {
        if (ordenRepository.findById(orden.getId()).isPresent()) {
            ordenRepository.update(orden);
            return true;
        }
        return false;
    }
    
    public boolean delete(Long ordenId) {
        if (ordenRepository.findById(ordenId).isPresent()) {
            ordenRepository.deleteById(ordenId);
            return true;
        }
        return false;
    }
    
    public List<OrdenDTO> getByCliente(Long clienteId) {
        return ordenRepository.findByClienteId(clienteId);
    }
}
