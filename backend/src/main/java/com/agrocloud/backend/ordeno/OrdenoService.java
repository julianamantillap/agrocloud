package com.agrocloud.backend.ordeno;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.UUID;

@Service
public class OrdenoService {

    private final OrdenoRepository ordenoRepository;

    public OrdenoService(OrdenoRepository ordenoRepository) {
        this.ordenoRepository = ordenoRepository;
    }

    public List<Ordeno> listarTodos() {
        return ordenoRepository.findAll();
    }

    public List<Ordeno> listarPorAnimal(UUID animalId) {
        return ordenoRepository.findByAnimalId(animalId);
    }

    public List<Ordeno> listarPorLote(UUID loteId) {
        return ordenoRepository.findByLoteId(loteId);
    }

    public Ordeno buscarPorId(UUID id) {
        return ordenoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Ordeno no encontrado con id: " + id));
    }

    public Ordeno crear(Ordeno ordeno) {
        return ordenoRepository.save(ordeno);
    }

    public void eliminar(UUID id) {
        buscarPorId(id);
        ordenoRepository.deleteById(id);
    }
}
