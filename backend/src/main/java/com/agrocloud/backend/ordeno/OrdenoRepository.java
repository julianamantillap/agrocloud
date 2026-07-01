package com.agrocloud.backend.ordeno;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface OrdenoRepository extends JpaRepository<Ordeno, UUID> {
    List<Ordeno> findByAnimalId(UUID animalId);
    List<Ordeno> findByLoteId(UUID loteId);
}
