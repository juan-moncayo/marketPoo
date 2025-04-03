package com.example.marketAplication.domain.repository;

import com.example.marketAplication.domain.dto.PagoDTO;
import java.util.List;
import java.util.Optional;

public interface IPago {
    List<PagoDTO> findAll();
    Optional<PagoDTO> findById(Long id);
    PagoDTO save(PagoDTO pagoDTO);
    void update(PagoDTO pagoDTO);
    void deleteById(Long id);
    List<PagoDTO> findByOrdenId(Long ordenId);
}
