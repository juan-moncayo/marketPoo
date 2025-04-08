package com.example.marketAplication.infraestructure.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.marketAplication.domain.dto.ClienteDTO;
import com.example.marketAplication.infraestructure.entity.Cliente;

@Component
public class ClienteMapper {
    
    public ClienteDTO toClienteDTO(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setName(cliente.getNombre());
        dto.setEmail(cliente.getEmail());
        dto.setAddress(cliente.getDireccion());
        dto.setPhone(cliente.getTelefono());
        
        return dto;
    }
    
    public List<ClienteDTO> toClienteDTOs(List<Cliente> clientes) {
        if (clientes == null) {
            return null;
        }
        
        List<ClienteDTO> dtos = new ArrayList<>(clientes.size());
        for (Cliente cliente : clientes) {
            dtos.add(toClienteDTO(cliente));
        }
        
        return dtos;
    }
    
    public Cliente toCliente(ClienteDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNombre(dto.getName());
        cliente.setEmail(dto.getEmail());
        cliente.setDireccion(dto.getAddress());
        cliente.setTelefono(dto.getPhone());
        
        return cliente;
    }
}