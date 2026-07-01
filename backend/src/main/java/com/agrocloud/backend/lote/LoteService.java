package com.agrocloud.backend.lote;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.UUID;

@Service
public class LoteService {

    private final LoteRepository loteRepository;

    public LoteService(LoteRepository loteRepository) {
        this.loteRepository = loteRepository;
    }

    public List<Lote> listarTodos() {
        return loteRepository.findAll();
    }

    public Lote buscarPorId(UUID id) {
        return loteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Lote no encontrado con id: " + id));
    }

    public Lote crear(Lote lote) {
        return loteRepository.save(lote);
    }

    public Lote actualizar(UUID id, Lote datos) {
        Lote lote = buscarPorId(id);
        lote.setCodigo(datos.getCodigo());
        lote.setCapacidad(datos.getCapacidad());
        lote.setEstado(datos.getEstado());
        lote.setDescripcion(datos.getDescripcion());
        lote.setArchivoAdjuntoUrl(datos.getArchivoAdjuntoUrl());
        return loteRepository.save(lote);
    }

    public void eliminar(UUID id) {
        buscarPorId(id);
        loteRepository.deleteById(id);
    }
}
