package com.agrocloud.backend.nacimiento;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "nacimiento")
public class Nacimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "animal_id", nullable = false)
    private UUID animalId;

    @Column(name = "madre_id")
    private UUID madreId;

    @Column(name = "padre_id")
    private UUID padreId;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    private String observaciones;

    @Column(name = "creado_en", nullable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    public Nacimiento() {}

    public UUID getId() { return id; }
    public UUID getAnimalId() { return animalId; }
    public void setAnimalId(UUID animalId) { this.animalId = animalId; }
    public UUID getMadreId() { return madreId; }
    public void setMadreId(UUID madreId) { this.madreId = madreId; }
    public UUID getPadreId() { return padreId; }
    public void setPadreId(UUID padreId) { this.padreId = padreId; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fecha) { this.fechaNacimiento = fecha; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String obs) { this.observaciones = obs; }
    public LocalDateTime getCreadoEn() { return creadoEn; }
}
