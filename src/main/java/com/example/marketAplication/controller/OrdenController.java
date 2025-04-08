package com.example.marketAplication.controller;

import com.example.marketAplication.domain.dto.OrdenDTO;
import com.example.marketAplication.domain.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {
    
    private final OrdenService ordenService;
    
    @Autowired
    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }
    
    @GetMapping
    public ResponseEntity<List<OrdenDTO>> getAll() {
        return ResponseEntity.ok(ordenService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<OrdenDTO> getOrden(@PathVariable("id") Long ordenId) {
        return ordenService.getOrden(ordenId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<OrdenDTO> save(@RequestBody OrdenDTO orden) {
        return new ResponseEntity<>(ordenService.save(orden), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long ordenId, @RequestBody OrdenDTO orden) {
        orden.setId(ordenId);
        if (ordenService.update(orden)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long ordenId) {
        if (ordenService.delete(ordenId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<OrdenDTO>> getByCliente(@PathVariable("clienteId") Long clienteId) {
        return ResponseEntity.ok(ordenService.getByCliente(clienteId));
    }
}
