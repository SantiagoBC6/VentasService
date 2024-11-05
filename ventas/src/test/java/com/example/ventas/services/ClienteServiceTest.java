package com.example.ventas.services;

import com.example.ventas.model.Cliente;
import com.example.ventas.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClienteServiceTest {
    @MockBean
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @Test
    public void testObtenerClientePorId() {
        Cliente cliente = new Cliente(1L, "Juan", "juan@example.com","+57987654321","Avenida Siempre Viva 742");
        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Optional<Cliente> resultado = clienteService.obtenerPorId(1L);

        assertNotNull(resultado);
        assertEquals("Juan", resultado.get().getNombre());
    }

    @Test
    public void testCrearCliente() {
        Cliente cliente = new Cliente(null, "Maria", "maria@example.com", "+58987654321", "Campestre B");
        Mockito.when(clienteRepository.save(cliente)).thenReturn(new Cliente(2L, "Maria", "maria@example.com", "+58987654321", "Campestre B"));

        Cliente resultado = clienteService.crear(cliente);

        assertNotNull(resultado.getId());
        assertEquals("Maria", resultado.getNombre());
    }
}
