package com.agrocloud.backend.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AnimalRepository extends JpaRepository<Animal, UUID> {
    // JpaRepository ya nos da gratis: findAll(), findById(), save(), deleteById(), etc.
    // Aqui despues agregaremos metodos personalizados, por ejemplo:
    // List<Animal> findByLoteId(UUID loteId);
}
