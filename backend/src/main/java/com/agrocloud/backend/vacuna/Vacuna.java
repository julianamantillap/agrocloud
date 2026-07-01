package com.agrocloud.backend.vacuna;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "vacuna")
public class Vacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "animal_id", nullable = false)
    private UUID animalId;

    @Column(name = "tipo_tratamiento", nullable = false, length = 80)
    private String tipoTratamiento;

    @Column(length = 100)
    private String medicamento;

    @Column(length = 50)
    private String dosis;

    @Column(nullable = false)
    private LocalDate fecha;

    private String observaciones;

    @Column(name = "registrado_por_usuario_id")
    private UUID registradoPorUsuarioId;

    @Column(name = "creado_en", nullable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    public Vacuna() {}

    public UUID getId() { return id; }
    public UUID getAnimalId() { return animalId; }
    public void setAnimalId(UUID animalId) { this.animalId = animalId; }
    public String getTipoTratamiento() { return tipoTratamiento; }
    public void setTipoTratamiento(String t) { this.tipoTratamiento = t; }
    public String getMedicamento() { return medicamento; }
    public void setMedicamento(String m) { this.medicamento = m; }
    public String getDosis() { return dosis; }
    public void setDosis(String d) { this.dosis = d; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String obs) { this.observaciones = obs; }
    public UUID getRegistradoPorUsuarioId() { return registradoPorUsuarioId; }
    public void setRegistradoPorUsuarioId(UUID id) { this.registradoPorUsuarioId = id; }
    public LocalDateTime getCreadoEn() { return creadoEn; }
}
