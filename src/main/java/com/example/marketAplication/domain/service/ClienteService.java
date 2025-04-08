package com.example.marketAplication.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.marketAplication.domain.dto.ClienteDTO;
import com.example.marketAplication.domain.repository.ICliente;

@Service
public class ClienteService {
    
    @Autowired
    private ICliente clienteRepository;
    
    public List<ClienteDTO> getAllClientes() {
        return clienteRepository.getAll();
    }
    
    public Optional<ClienteDTO> getCliente(Long id) {
        return clienteRepository.getById(id);
    }
    
    public ClienteDTO saveCliente(ClienteDTO clienteDTO) {
        return clienteRepository.save(clienteDTO);
    }
    
    public boolean updateCliente(ClienteDTO clienteDTO) {
        if (clienteRepository.getById(clienteDTO.getId()).isPresent()) {
            clienteRepository.update(clienteDTO);
            return true;
        }
        return false;
    }
    
    public boolean deleteCliente(Long id) {
        if (clienteRepository.getById(id).isPresent()) {
            clienteRepository.delete(id);
            return true;
        }
        return false;
    }
}