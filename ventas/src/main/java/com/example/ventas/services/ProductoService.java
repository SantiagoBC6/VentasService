package com.example.ventas.services;

import com.example.ventas.model.Producto;
import com.example.ventas.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        log.info("Obteniendo todos los productos");
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        log.info("Buscando producto por ID: {}", id);
        return productoRepository.findById(id);
    }

    public Producto crear(Producto producto) {
        log.info("Creando nuevo producto: {}", producto);
        return productoRepository.save(producto);
    }

    public Producto actualizar(Long id, Producto producto) {
        log.info("Actualizando producto con ID {}", id);
        producto.setId(id);
        return productoRepository.save(producto);
    }

    public void eliminar(Long id) {
        log.info("Eliminando producto con ID: {}", id);
        productoRepository.deleteById(id);
    }

}