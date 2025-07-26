package com.TCC.SistemaPaese.repositories;

import com.TCC.SistemaPaese.models.entities.Incidents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentsRepository extends JpaRepository<Incidents, Long> {
}
