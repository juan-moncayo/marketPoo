package com.example.marketAplication.infraestructure.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.marketAplication.infraestructure.entity.Producto;


@Repository
public interface ProductRepository extends JpaRepository<Producto, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario


}
