package com.example.ventas.services;

import com.example.ventas.model.Venta;
import com.example.ventas.repository.VentaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar operaciones relacionadas con Ventas.
 * Proporciona métodos para crear, leer, actualizar y eliminar Ventas.
 */
@Slf4j
@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private EnvioService envioService;

    public List<Venta> obtenerTodos() {
        log.info("Obteniendo todas las ventas");
        return ventaRepository.findAll();
    }

    public Optional<Venta> obtenerPorId(Long id) {
        log.info("Buscando venta con ID: {}", id);
        return ventaRepository.findById(id);
    }

    public Venta crear(Venta venta) {
        log.info("Creando nueva venta: {}", venta);
        Venta ventaCreada = ventaRepository.save(venta);
        Venta ventaConsult = ventaRepository.findById(ventaCreada.getId())
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada con ID: " + ventaCreada.getId()));
        log.info("Registrando envío apenas se ejecuta la venta: {}", venta);
        envioService.crearEnvio(ventaConsult.getId());
        return ventaCreada;
    }

    public Venta actualizar(Long id, Venta venta) {
        log.info("Actualizando venta con ID: {}", id);
        venta.setId(id);
        return ventaRepository.save(venta);
    }

    public void eliminar(Long id) {
        log.info("Eliminando venta con ID: {}", id);
        ventaRepository.deleteById(id);
    }
}