package com.example.marketAplication.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrdenDTO {
    private Long id;
    private LocalDateTime fecha;
    private BigDecimal total;
    private String estado;
    private Long clienteId;
    private List<OrdenItemDTO> items;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<OrdenItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrdenItemDTO> items) {
        this.items = items;
    }
}
