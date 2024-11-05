package com.example.ventas.repository;

import com.example.ventas.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * Interfaz de repositorio para la entidad Envio.
 * Extiende JpaRepository para proporcionar métodos CRUD básicos.
 */
@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {
}