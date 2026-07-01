package com.agrocloud.backend.nacimiento;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.UUID;

@Service
public class NacimientoService {

    private final NacimientoRepository nacimientoRepository;

    public NacimientoService(NacimientoRepository nacimientoRepository) {
        this.nacimientoRepository = nacimientoRepository;
    }

    public List<Nacimiento> listarTodos() {
        return nacimientoRepository.findAll();
    }

    public List<Nacimiento> listarPorAnimal(UUID animalId) {
        return nacimientoRepository.findByAnimalId(animalId);
    }

    public List<Nacimiento> listarPorMadre(UUID madreId) {
        return nacimientoRepository.findByMadreId(madreId);
    }

    public Nacimiento buscarPorId(UUID id) {
        return nacimientoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Nacimiento no encontrado con id: " + id));
    }

    public Nacimiento crear(Nacimiento nacimiento) {
        return nacimientoRepository.save(nacimiento);
    }

    public void eliminar(UUID id) {
        buscarPorId(id);
        nacimientoRepository.deleteById(id);
    }
}
