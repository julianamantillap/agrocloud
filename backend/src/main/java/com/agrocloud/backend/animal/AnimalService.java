package com.agrocloud.backend.animal;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.UUID;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    public Animal buscarPorId(UUID id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Animal no encontrado con id: " + id));
    }

    public Animal crear(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal actualizar(UUID id, Animal datos) {
        Animal animal = buscarPorId(id);
        animal.setCodigo(datos.getCodigo());
        animal.setEspecie(datos.getEspecie());
        animal.setRaza(datos.getRaza());
        animal.setSexo(datos.getSexo());
        animal.setFechaNacimiento(datos.getFechaNacimiento());
        animal.setPesoActual(datos.getPesoActual());
        animal.setLoteId(datos.getLoteId());
        animal.setEstado(datos.getEstado());
        return animalRepository.save(animal);
    }

    public void eliminar(UUID id) {
        buscarPorId(id); // lanza 404 si no existe
        animalRepository.deleteById(id);
    }
}
