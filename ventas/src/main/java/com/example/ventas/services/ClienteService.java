package com.example.ventas.services;

import com.example.ventas.model.Cliente;
import com.example.ventas.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodos() {
        log.info("Obteniendo todos los clientes");
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerPorId(Long id) {
        log.info("Buscando cliente por ID: {}", id);
        return clienteRepository.findById(id);
    }

    public Cliente crear(Cliente cliente) {
        log.info("Creando nuevo cliente: {}", cliente);
        return clienteRepository.save(cliente);
    }

    public Cliente actualizar(Long id, Cliente cliente) {
        log.info("Actualizando cliente con ID {}", id);
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void eliminar(Long id) {
        log.info("Eliminando cliente con ID: {}", id);
        clienteRepository.deleteById(id);
    }
}