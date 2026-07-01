package com.agrocloud.backend.pesaje;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface PesajeRepository extends JpaRepository<Pesaje, UUID> {
    List<Pesaje> findByAnimalId(UUID animalId);
}
