package com.example.ventas.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/***
 * Clase que representa la entidad Envios en la base de datos.
 * Mapea la tabla 'envios' y define sus atributos.
 */
@Data
@Entity
@Table(name = "envios")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    private Venta ventaId;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "fecha_envio", nullable = false)
    private LocalDateTime fechaEnvio;

    @Column(name = "fecha_entrega")
    private LocalDateTime fechaEntrega;

    public Envio() {
    }

    public Envio(Long id, Venta ventaId, String estado, LocalDateTime fechaEnvio, LocalDateTime fechaEntrega) {
        this.id = id;
        this.ventaId = ventaId;
        this.estado = estado;
        this.fechaEnvio = fechaEnvio;
        this.fechaEntrega = fechaEntrega;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venta getVentaId() {
        return ventaId;
    }

    public void setVentaId(Venta ventaId) {
        this.ventaId = ventaId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
}
