package com.agrocloud.backend.animal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/animales")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> listar() {
        return animalService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(animalService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Animal> crear(@RequestBody Animal animal) {
        return ResponseEntity.status(201).body(animalService.crear(animal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> actualizar(@PathVariable UUID id, @RequestBody Animal datos) {
        return ResponseEntity.ok(animalService.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        animalService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
