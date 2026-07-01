package com.agrocloud.backend.nacimiento;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface NacimientoRepository extends JpaRepository<Nacimiento, UUID> {
    List<Nacimiento> findByAnimalId(UUID animalId);
    List<Nacimiento> findByMadreId(UUID madreId);
}
