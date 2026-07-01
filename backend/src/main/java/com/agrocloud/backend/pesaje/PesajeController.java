package com.agrocloud.backend.pesaje;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pesajes")
public class PesajeController {

    private final PesajeService pesajeService;

    public PesajeController(PesajeService pesajeService) {
        this.pesajeService = pesajeService;
    }

    @GetMapping
    public List<Pesaje> listar() {
        return pesajeService.listarTodos();
    }

    @GetMapping("/animal/{animalId}")
    public List<Pesaje> listarPorAnimal(@PathVariable UUID animalId) {
        return pesajeService.listarPorAnimal(animalId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pesaje> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(pesajeService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Pesaje> crear(@RequestBody Pesaje pesaje) {
        return ResponseEntity.status(201).body(pesajeService.crear(pesaje));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        pesajeService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
