package com.example.ventas.services;

import com.example.ventas.model.Envio;
import com.example.ventas.model.Venta;
import com.example.ventas.repository.EnvioRepository;
import com.example.ventas.repository.VentaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Servicio para gestionar operaciones relacionadas con Envios.
 * Proporciona métodos para crear y eliminar envíos.
 */
@Slf4j
@Service
public class EnvioService {
    @Autowired
    private EnvioRepository envioRepository;

    @Autowired
    private VentaRepository ventaRepository;

    public Envio crearEnvio(Long ventaId) {
        log.info("Creando la trazabilidad de envío, cuando se genera una venta.");
        Envio envio = new Envio();
        Venta venta = ventaRepository.findById(ventaId)
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada con ID: " + ventaId));
        envio.setVentaId(venta);
        envio.setEstado("Pendiente");
        envio.setFechaEnvio(LocalDateTime.now());
        envio.setFechaEntrega(LocalDateTime.now().plusDays(10));
        return envioRepository.save(envio);
    }

    public void eliminar(Long id) {
        log.info("Eliminando Venta con ID: {}", id);
        envioRepository.deleteById(id);
    }

}
