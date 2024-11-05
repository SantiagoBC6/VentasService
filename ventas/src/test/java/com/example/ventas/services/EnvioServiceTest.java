package com.example.ventas.services;

import com.example.ventas.model.Cliente;
import com.example.ventas.model.Envio;
import com.example.ventas.model.Producto;
import com.example.ventas.model.Venta;
import com.example.ventas.repository.ClienteRepository;
import com.example.ventas.repository.ProductoRepository;
import com.example.ventas.repository.VentaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class EnvioServiceTest {
    @Autowired
    private EnvioService envioService;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VentaRepository ventaRepository;

    private Long ventaId;

    @BeforeEach
    public void setUp() {
        Venta venta = new Venta();
        venta.setId(1L);
        Producto producto = productoRepository.findById(venta.getId())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + venta.getId()));
        venta.setProducto(producto);
        Cliente cliente = clienteRepository.findById(venta.getId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + venta.getId()));
        venta.setCliente(cliente);
        venta.setCantidad(10);
        venta.setEstado("NUEVO PEDIDO");
        ventaRepository.save(venta);

        ventaId = venta.getId();
    }

    @Test
    public void testCrearEnvio() {
        Envio envio = envioService.crearEnvio(ventaId);
        assertNotNull(envio);
        assertEquals(ventaId, envio.getVentaId().getId());
        assertEquals("Pendiente", envio.getEstado());
        assertNotNull(envio.getFechaEnvio());
        assertTrue(envio.getFechaEntrega().isAfter(envio.getFechaEnvio()));
    }

    @Test
    public void testCrearEnvio_ventaNoExistente() {
        // Intentamos crear un envío con una venta que no existe
        assertThrows(IllegalArgumentException.class, () -> {
            envioService.crearEnvio(999L);
        });
    }
}
