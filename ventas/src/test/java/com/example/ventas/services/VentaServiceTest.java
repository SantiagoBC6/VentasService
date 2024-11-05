package com.example.ventas.services;

import com.example.ventas.model.Venta;
import com.example.ventas.repository.VentaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VentaServiceTest {

    @MockBean
    private VentaRepository ventaRepository;

    @MockBean
    private EnvioService envioService;

    @Autowired
    private VentaService ventaService;

    @Test
    public void testCrearVenta() {
        Venta venta = new Venta();
        venta.setId(1L);
        venta.setCantidad(10);
        venta.setEstado("Pendiente");

        Mockito.when(ventaRepository.save(venta)).thenReturn(venta);
        Mockito.when(ventaRepository.findById(1L)).thenReturn(Optional.of(venta));

        Venta ventaCreada = ventaService.crear(venta);

        assertNotNull(ventaCreada);
        assertEquals(1L, ventaCreada.getId());
        assertEquals("Pendiente", ventaCreada.getEstado());
        Mockito.verify(envioService, Mockito.times(1)).crearEnvio(1L);
    }

    @Test
    public void testObtenerVentaPorId() {
        Venta venta = new Venta();
        venta.setId(1L);
        venta.setCantidad(10);
        venta.setEstado("Pendiente");

        Mockito.when(ventaRepository.findById(1L)).thenReturn(Optional.of(venta));

        Optional<Venta> ventaConsultada = ventaService.obtenerPorId(1L);

        assertTrue(ventaConsultada.isPresent());
        assertEquals(1L, ventaConsultada.get().getId());
        assertEquals("Pendiente", ventaConsultada.get().getEstado());
    }
}
