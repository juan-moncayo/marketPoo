package com.example.marketAplication.infraestructure.repositories;

import com.example.marketAplication.domain.dto.OrdenItemDTO;
import com.example.marketAplication.infraestructure.entity.OrdenItem;
import com.example.marketAplication.infraestructure.entity.Orden;
import com.example.marketAplication.infraestructure.entity.Producto;
import com.example.marketAplication.domain.repository.IOrdenItem;
import com.example.marketAplication.infraestructure.crud.OrdenItemRepository;
import com.example.marketAplication.infraestructure.crud.OrdenRepository;
import com.example.marketAplication.infraestructure.crud.ProductRepository;
import com.example.marketAplication.infraestructure.mapper.OrdenItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class OrdenItemImpement implements IOrdenItem {
    
    private final OrdenItemRepository ordenItemRepository;
    private final OrdenRepository ordenRepository;
    private final ProductRepository productRepository;
    private final OrdenItemMapper mapper;
    
    @Autowired
    public OrdenItemImpement(OrdenItemRepository ordenItemRepository, 
                             OrdenRepository ordenRepository,
                             ProductRepository productRepository,
                             OrdenItemMapper mapper) {
        this.ordenItemRepository = ordenItemRepository;
        this.ordenRepository = ordenRepository;
        this.productRepository = productRepository;
        this.mapper = mapper;
    }
    
    @Override
    public List<OrdenItemDTO> findByOrdenId(Long ordenId) {
        return mapper.toOrdenItemDTOs(ordenItemRepository.findByOrdenId(ordenId));
    }
    
    @Override
    public Optional<OrdenItemDTO> findById(Long id) {
        return ordenItemRepository.findById(id)
                .map(mapper::toOrdenItemDTO);
    }
    
    @Override
    public OrdenItemDTO save(OrdenItemDTO ordenItemDTO) {
        OrdenItem ordenItem = mapper.toOrdenItem(ordenItemDTO);
        
        Optional<Producto> producto = productRepository.findById(ordenItemDTO.getProductoId());
        Optional<Orden> orden = ordenRepository.findById(ordenItemDTO.getOrdenId());
        
        if (producto.isPresent() && orden.isPresent()) {
            ordenItem.setProducto(producto.get());
            ordenItem.setOrden(orden.get());
            return mapper.toOrdenItemDTO(ordenItemRepository.save(ordenItem));
        }
        
        return null;
    }
    
    @Override
    public void update(OrdenItemDTO ordenItemDTO) {
        OrdenItem ordenItem = mapper.toOrdenItem(ordenItemDTO);
        
        Optional<Producto> producto = productRepository.findById(ordenItemDTO.getProductoId());
        Optional<Orden> orden = ordenRepository.findById(ordenItemDTO.getOrdenId());
        
        if (producto.isPresent() && orden.isPresent()) {
            ordenItem.setProducto(producto.get());
            ordenItem.setOrden(orden.get());
            ordenItemRepository.save(ordenItem);
        }
    }
    
    @Override
    public void deleteById(Long id) {
        ordenItemRepository.deleteById(id);
    }
}

