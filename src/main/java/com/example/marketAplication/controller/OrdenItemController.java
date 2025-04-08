package com.example.marketAplication.controller;

import com.example.marketAplication.domain.dto.OrdenItemDTO;
import com.example.marketAplication.domain.service.OrdenItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ordenes/{ordenId}/items")
public class OrdenItemController {
    
    private final OrdenItemService ordenItemService;
    
    @Autowired
    public OrdenItemController(OrdenItemService ordenItemService) {
        this.ordenItemService = ordenItemService;
    }
    
    @GetMapping
    public ResponseEntity<List<OrdenItemDTO>> getByOrden(@PathVariable("ordenId") Long ordenId) {
        return ResponseEntity.ok(ordenItemService.getByOrden(ordenId));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<OrdenItemDTO> getItem(@PathVariable("id") Long itemId) {
        return ordenItemService.getItem(itemId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<OrdenItemDTO> save(@RequestBody OrdenItemDTO item) {
        return new ResponseEntity<>(ordenItemService.save(item), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long itemId, @RequestBody OrdenItemDTO item) {
        item.setId(itemId);
        if (ordenItemService.update(item)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long itemId) {
        if (ordenItemService.delete(itemId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

