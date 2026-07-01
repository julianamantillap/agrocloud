package com.agrocloud.backend.lote;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lotes")
public class LoteController {

    private final LoteService loteService;

    public LoteController(LoteService loteService) {
        this.loteService = loteService;
    }

    @GetMapping
    public List<Lote> listar() {
        return loteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lote> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(loteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Lote> crear(@RequestBody Lote lote) {
        return ResponseEntity.status(201).body(loteService.crear(lote));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lote> actualizar(@PathVariable UUID id, @RequestBody Lote datos) {
        return ResponseEntity.ok(loteService.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        loteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
