package com.example.ventas.repository;

import com.example.ventas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * Interfaz de repositorio para la entidad Cliente.
 * Extiende JpaRepository para proporcionar métodos CRUD básicos.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}