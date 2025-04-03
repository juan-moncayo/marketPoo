package com.example.marketAplication.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.marketAplication.domain.dto.ClienteDTO;

public interface ICliente {
    
    List<ClienteDTO> getAll();
    
    Optional<ClienteDTO> getById(Long id);
    
    ClienteDTO save(ClienteDTO clienteDTO);
    
    void update(ClienteDTO clienteDTO);
    
    void delete(Long id);
}
