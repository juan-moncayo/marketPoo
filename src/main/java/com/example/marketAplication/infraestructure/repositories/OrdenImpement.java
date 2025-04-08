package com.example.marketAplication.infraestructure.repositories;

import com.example.marketAplication.domain.dto.OrdenDTO;
import com.example.marketAplication.infraestructure.entity.Cliente;
import com.example.marketAplication.domain.repository.IOrden;
import com.example.marketAplication.infraestructure.crud.ClienteRepository;
import com.example.marketAplication.infraestructure.crud.OrdenRepository;
import com.example.marketAplication.infraestructure.mapper.OrdenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class OrdenImpement implements IOrden {
    
    private final OrdenRepository ordenRepository;
    private final ClienteRepository clienteRepository;
    private final OrdenMapper mapper;
    
    @Autowired
    public OrdenImpement(OrdenRepository ordenRepository, ClienteRepository clienteRepository, OrdenMapper mapper) {
        this.ordenRepository = ordenRepository;
        this.clienteRepository = clienteRepository;
        this.mapper = mapper;
    }
    
    @Override
    public List<OrdenDTO> findAll() {
        return mapper.toOrdenDTOs(ordenRepository.findAll());
    }
    
    @Override
    public Optional<OrdenDTO> findById(Long id) {
        return ordenRepository.findById(id)
                .map(mapper::toOrdenDTO);
    }
    
    @Override
    public OrdenDTO save(OrdenDTO ordenDTO) {
        com.example.marketAplication.infraestructure.entity.Orden orden = mapper.toOrden(ordenDTO);
        Optional<Cliente> cliente = clienteRepository.findById(ordenDTO.getClienteId());
        cliente.ifPresent(orden::setCliente);
        return mapper.toOrdenDTO(ordenRepository.save(orden));
    }
    
    @Override
    public void update(OrdenDTO ordenDTO) {
        com.example.marketAplication.infraestructure.entity.Orden orden = mapper.toOrden(ordenDTO);
        Optional<Cliente> cliente = clienteRepository.findById(ordenDTO.getClienteId());
        cliente.ifPresent(orden::setCliente);
        ordenRepository.save(orden);
    }
    
    @Override
    public void deleteById(Long id) {
        ordenRepository.deleteById(id);
    }
    
    @Override
    public List<OrdenDTO> findByClienteId(Long clienteId) {
        return mapper.toOrdenDTOs(ordenRepository.findByClienteId(clienteId));
    }
}
