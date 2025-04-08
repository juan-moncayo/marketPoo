package com.example.marketAplication.domain.service;

import com.example.marketAplication.domain.dto.OrdenItemDTO;
import com.example.marketAplication.domain.repository.IOrdenItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenItemService {
    
    private final IOrdenItem ordenItemRepository;
    
    @Autowired
    public OrdenItemService(IOrdenItem ordenItemRepository) {
        this.ordenItemRepository = ordenItemRepository;
    }
    
    public List<OrdenItemDTO> getByOrden(Long ordenId) {
        return ordenItemRepository.findByOrdenId(ordenId);
    }
    
    public Optional<OrdenItemDTO> getItem(Long itemId) {
        return ordenItemRepository.findById(itemId);
    }
    
    public OrdenItemDTO save(OrdenItemDTO item) {
        return ordenItemRepository.save(item);
    }
    
    public boolean update(OrdenItemDTO item) {
        if (ordenItemRepository.findById(item.getId()).isPresent()) {
            ordenItemRepository.update(item);
            return true;
        }
        return false;
    }
    
    public boolean delete(Long itemId) {
        if (ordenItemRepository.findById(itemId).isPresent()) {
            ordenItemRepository.deleteById(itemId);
            return true;
        }
        return false;
    }
}

