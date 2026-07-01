package com.agrocloud.backend.animal;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    // Spring inyecta automaticamente el repositorio aqui
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    public Animal buscarPorId(UUID id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal no encontrado con id: " + id));
    }

    public Animal crear(Animal animal) {
        return animalRepository.save(animal);
    }

    public void eliminar(UUID id) {
        animalRepository.deleteById(id);
    }
}
