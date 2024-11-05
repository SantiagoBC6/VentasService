package com.example.ventas.repository;

import com.example.ventas.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * Interfaz de repositorio para la entidad Producto.
 * Extiende JpaRepository para proporcionar métodos CRUD básicos.
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}