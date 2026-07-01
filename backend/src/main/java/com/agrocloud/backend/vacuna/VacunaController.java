package com.agrocloud.backend.vacuna;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vacunas")
public class VacunaController {

    private final VacunaService vacunaService;

    public VacunaController(VacunaService vacunaService) {
        this.vacunaService = vacunaService;
    }

    @GetMapping
    public List<Vacuna> listar() {
        return vacunaService.listarTodos();
    }

    @GetMapping("/animal/{animalId}")
    public List<Vacuna> listarPorAnimal(@PathVariable UUID animalId) {
        return vacunaService.listarPorAnimal(animalId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vacuna> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(vacunaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Vacuna> crear(@RequestBody Vacuna vacuna) {
        return ResponseEntity.status(201).body(vacunaService.crear(vacuna));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        vacunaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
