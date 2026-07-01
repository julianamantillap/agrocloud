package com.agrocloud.backend.lote;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface LoteRepository extends JpaRepository<Lote, UUID> {
}
