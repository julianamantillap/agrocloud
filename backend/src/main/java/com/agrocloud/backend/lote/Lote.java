package com.agrocloud.backend.lote;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "lote")
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 30)
    private String codigo;

    private Integer capacidad;

    @Column(nullable = false, length = 20)
    private String estado = "activo";

    private String descripcion;

    @Column(name = "archivo_adjunto_url")
    private String archivoAdjuntoUrl;

    @Column(name = "creado_en", nullable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    public Lote() {}

    public UUID getId() { return id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getArchivoAdjuntoUrl() { return archivoAdjuntoUrl; }
    public void setArchivoAdjuntoUrl(String url) { this.archivoAdjuntoUrl = url; }
    public LocalDateTime getCreadoEn() { return creadoEn; }
}
