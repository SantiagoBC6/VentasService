package com.example.ventas.services;

import com.example.ventas.model.Producto;
import com.example.ventas.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductoServiceTest {

    @MockBean
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoService productoService;

    @Test
    public void testObtenerProductoPorId() {
        Producto producto = new Producto(1L, "Laptop HP 2024", "Nueva", 15000.99,20);
        Mockito.when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));

        Optional<Producto> resultado = productoService.obtenerPorId(1L);

        assertNotNull(resultado);
        assertEquals("Laptop HP 2024", resultado.get().getNombre());
    }

    @Test
    public void testCrearProducto() {
        Producto producto = new Producto(null, "Telefono Apple 2023", "Usado", 800.0,5);
        Mockito.when(productoRepository.save(producto)).thenReturn(new Producto(2L, "Telefono Apple 2023", "Usado", 800.0,5));

        Producto resultado = productoService.crear(producto);

        assertNotNull(resultado.getId());
        assertEquals("Telefono Apple 2023", resultado.getNombre());
    }
}
