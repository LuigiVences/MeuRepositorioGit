package com.TCC.SistemaPaese.dto;

import com.TCC.SistemaPaese.models.entities.OrganizationalUnit;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record CreateEmployeeDTO(
        @NotBlank
        String name,
        @Email
        @NotBlank
        String email,
        OrganizationalUnit organizational_unit_id) {
}
