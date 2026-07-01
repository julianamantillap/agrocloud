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

    // GET /api/animales - lista todos los animales
    @GetMapping
    public List<Animal> listar() {
        return animalService.listarTodos();
    }

    // GET /api/animales/{id} - busca un animal por id
    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(animalService.buscarPorId(id));
    }

    // POST /api/animales - crea un nuevo animal
    @PostMapping
    public ResponseEntity<Animal> crear(@RequestBody Animal animal) {
        Animal creado = animalService.crear(animal);
        return ResponseEntity.status(201).body(creado);
    }

    // DELETE /api/animales/{id} - elimina un animal
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        animalService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
