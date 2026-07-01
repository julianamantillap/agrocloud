package com.agrocloud.backend.animal;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 30)
    private String codigo;

    @Column(nullable = false, length = 50)
    private String especie;

    @Column(length = 50)
    private String raza;

    @Column(nullable = false, length = 10)
    private String sexo;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "peso_actual", columnDefinition = "numeric(6,2)")
    private BigDecimal pesoActual;

    @Column(name = "lote_id")
    private UUID loteId;

    @Column(nullable = false, length = 20)
    private String estado = "activo";

    @Column(nullable = false)
    private Boolean sincronizado = true;

    @Column(name = "creado_en", nullable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    public Animal() {}

    public UUID getId() { return id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }
    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public BigDecimal getPesoActual() { return pesoActual; }
    public void setPesoActual(BigDecimal pesoActual) { this.pesoActual = pesoActual; }
    public UUID getLoteId() { return loteId; }
    public void setLoteId(UUID loteId) { this.loteId = loteId; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Boolean getSincronizado() { return sincronizado; }
    public void setSincronizado(Boolean sincronizado) { this.sincronizado = sincronizado; }
    public LocalDateTime getCreadoEn() { return creadoEn; }
}
