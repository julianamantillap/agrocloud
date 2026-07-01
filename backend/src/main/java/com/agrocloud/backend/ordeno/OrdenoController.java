package com.agrocloud.backend.ordeno;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/ordenos")
public class OrdenoController {

    private final OrdenoService ordenoService;

    public OrdenoController(OrdenoService ordenoService) {
        this.ordenoService = ordenoService;
    }

    @GetMapping
    public List<Ordeno> listar() {
        return ordenoService.listarTodos();
    }

    @GetMapping("/animal/{animalId}")
    public List<Ordeno> listarPorAnimal(@PathVariable UUID animalId) {
        return ordenoService.listarPorAnimal(animalId);
    }

    @GetMapping("/lote/{loteId}")
    public List<Ordeno> listarPorLote(@PathVariable UUID loteId) {
        return ordenoService.listarPorLote(loteId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ordeno> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(ordenoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Ordeno> crear(@RequestBody Ordeno ordeno) {
        return ResponseEntity.status(201).body(ordenoService.crear(ordeno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        ordenoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
