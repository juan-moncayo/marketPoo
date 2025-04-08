package com.example.marketAplication.controller;

import com.example.marketAplication.domain.dto.PagoDTO;
import com.example.marketAplication.domain.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {
    
    private final PagoService pagoService;
    
    @Autowired
    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }
    
    @GetMapping
    public ResponseEntity<List<PagoDTO>> getAll() {
        return ResponseEntity.ok(pagoService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> getPago(@PathVariable("id") Long pagoId) {
        return pagoService.getPago(pagoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<PagoDTO> save(@RequestBody PagoDTO pago) {
        return new ResponseEntity<>(pagoService.save(pago), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long pagoId, @RequestBody PagoDTO pago) {
        pago.setId(pagoId);
        if (pagoService.update(pago)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long pagoId) {
        if (pagoService.delete(pagoId)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/orden/{ordenId}")
    public ResponseEntity<List<PagoDTO>> getByOrden(@PathVariable("ordenId") Long ordenId) {
        return ResponseEntity.ok(pagoService.getByOrden(ordenId));
    }
}