package com.example.marketAplication.infraestructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.marketAplication.domain.dto.ClienteDTO;
import com.example.marketAplication.domain.repository.ICliente;
import com.example.marketAplication.infraestructure.crud.ClienteRepository;
import com.example.marketAplication.infraestructure.mapper.ClienteMapper;

@Repository
public class ClienteImplement implements ICliente {

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ClienteMapper mapper;
    
    @Override
    public List<ClienteDTO> getAll() {
        return mapper.toClienteDTOs(clienteRepository.findAll());
    }

    @Override
    public Optional<ClienteDTO> getById(Long id) {
        return clienteRepository.findById(id)
                .map(cliente -> mapper.toClienteDTO(cliente));
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        return mapper.toClienteDTO(
                clienteRepository.save(
                        mapper.toCliente(clienteDTO)
                )
        );
    }

    @Override
    public void update(ClienteDTO clienteDTO) {
        clienteRepository.save(mapper.toCliente(clienteDTO));
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}