package com.agrocloud.backend.nacimiento;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/nacimientos")
public class NacimientoController {

    private final NacimientoService nacimientoService;

    public NacimientoController(NacimientoService nacimientoService) {
        this.nacimientoService = nacimientoService;
    }

    @GetMapping
    public List<Nacimiento> listar() {
        return nacimientoService.listarTodos();
    }

    @GetMapping("/animal/{animalId}")
    public List<Nacimiento> listarPorAnimal(@PathVariable UUID animalId) {
        return nacimientoService.listarPorAnimal(animalId);
    }

    @GetMapping("/madre/{madreId}")
    public List<Nacimiento> listarPorMadre(@PathVariable UUID madreId) {
        return nacimientoService.listarPorMadre(madreId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nacimiento> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(nacimientoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Nacimiento> crear(@RequestBody Nacimiento nacimiento) {
        return ResponseEntity.status(201).body(nacimientoService.crear(nacimiento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        nacimientoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
