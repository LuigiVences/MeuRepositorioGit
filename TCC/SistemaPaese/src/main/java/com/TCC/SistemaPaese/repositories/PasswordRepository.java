package com.TCC.SistemaPaese.repositories;

import com.TCC.SistemaPaese.models.entities.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Password, Long> {
}
