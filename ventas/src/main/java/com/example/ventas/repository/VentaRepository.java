package com.example.ventas.repository;

import com.example.ventas.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * Interfaz de repositorio para la entidad Venta.
 * Extiende JpaRepository para proporcionar métodos CRUD básicos.
 */
@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
}