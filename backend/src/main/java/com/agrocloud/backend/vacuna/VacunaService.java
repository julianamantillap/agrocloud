package com.agrocloud.backend.vacuna;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.UUID;

@Service
public class VacunaService {

    private final VacunaRepository vacunaRepository;

    public VacunaService(VacunaRepository vacunaRepository) {
        this.vacunaRepository = vacunaRepository;
    }

    public List<Vacuna> listarTodos() {
        return vacunaRepository.findAll();
    }

    public List<Vacuna> listarPorAnimal(UUID animalId) {
        return vacunaRepository.findByAnimalId(animalId);
    }

    public Vacuna buscarPorId(UUID id) {
        return vacunaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Vacuna no encontrada con id: " + id));
    }

    public Vacuna crear(Vacuna vacuna) {
        return vacunaRepository.save(vacuna);
    }

    public void eliminar(UUID id) {
        buscarPorId(id);
        vacunaRepository.deleteById(id);
    }
}
