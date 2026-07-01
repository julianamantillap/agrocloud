package com.agrocloud.backend.vacuna;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface VacunaRepository extends JpaRepository<Vacuna, UUID> {
    List<Vacuna> findByAnimalId(UUID animalId);
}
