package com.example.marketAplication.domain.repository;

import com.example.marketAplication.domain.dto.OrdenItemDTO;
import java.util.List;
import java.util.Optional;

public interface IOrdenItem {
    List<OrdenItemDTO> findByOrdenId(Long ordenId);
    Optional<OrdenItemDTO> findById(Long id);
    OrdenItemDTO save(OrdenItemDTO ordenItemDTO);
    void update(OrdenItemDTO ordenItemDTO);
    void deleteById(Long id);
}

