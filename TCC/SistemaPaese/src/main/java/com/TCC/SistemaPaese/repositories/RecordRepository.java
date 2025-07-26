package com.TCC.SistemaPaese.repositories;

import com.TCC.SistemaPaese.models.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record,Long> {
}
