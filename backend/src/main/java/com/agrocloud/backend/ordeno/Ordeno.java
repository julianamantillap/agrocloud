package com.agrocloud.backend.ordeno;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ordeno")
public class Ordeno {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "animal_id", nullable = false)
    private UUID animalId;

    @Column(name = "lote_id")
    private UUID loteId;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false, columnDefinition = "numeric(6,2)")
    private BigDecimal litros;

    private String observaciones;

    @Column(name = "registrado_por_usuario_id")
    private UUID registradoPorUsuarioId;

    @Column(nullable = false)
    private Boolean sincronizado = true;

    @Column(name = "creado_en", nullable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    public Ordeno() {}

    public UUID getId() { return id; }
    public UUID getAnimalId() { return animalId; }
    public void setAnimalId(UUID animalId) { this.animalId = animalId; }
    public UUID getLoteId() { return loteId; }
    public void setLoteId(UUID loteId) { this.loteId = loteId; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public BigDecimal getLitros() { return litros; }
    public void setLitros(BigDecimal litros) { this.litros = litros; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public UUID getRegistradoPorUsuarioId() { return registradoPorUsuarioId; }
    public void setRegistradoPorUsuarioId(UUID id) { this.registradoPorUsuarioId = id; }
    public Boolean getSincronizado() { return sincronizado; }
    public void setSincronizado(Boolean sincronizado) { this.sincronizado = sincronizado; }
    public LocalDateTime getCreadoEn() { return creadoEn; }
}
