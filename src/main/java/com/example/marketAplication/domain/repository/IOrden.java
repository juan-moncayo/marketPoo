package com.example.marketAplication.domain.repository;

import com.example.marketAplication.domain.dto.OrdenDTO;
import java.util.List;
import java.util.Optional;

public interface IOrden {
    List<OrdenDTO> findAll();
    Optional<OrdenDTO> findById(Long id);
    OrdenDTO save(OrdenDTO ordenDTO);
    void update(OrdenDTO ordenDTO);
    void deleteById(Long id);
    List<OrdenDTO> findByClienteId(Long clienteId);
}
