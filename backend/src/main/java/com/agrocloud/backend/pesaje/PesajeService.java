package com.agrocloud.backend.pesaje;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.UUID;

@Service
public class PesajeService {

    private final PesajeRepository pesajeRepository;

    public PesajeService(PesajeRepository pesajeRepository) {
        this.pesajeRepository = pesajeRepository;
    }

    public List<Pesaje> listarTodos() {
        return pesajeRepository.findAll();
    }

    public List<Pesaje> listarPorAnimal(UUID animalId) {
        return pesajeRepository.findByAnimalId(animalId);
    }

    public Pesaje buscarPorId(UUID id) {
        return pesajeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Pesaje no encontrado con id: " + id));
    }

    public Pesaje crear(Pesaje pesaje) {
        return pesajeRepository.save(pesaje);
    }

    public void eliminar(UUID id) {
        buscarPorId(id);
        pesajeRepository.deleteById(id);
    }
}
