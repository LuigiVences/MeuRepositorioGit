package com.TCC.SistemaPaese.dto;

import com.TCC.SistemaPaese.models.entities.Employee;

import java.time.LocalDateTime;

public record EmployeeDTO(Long id, String name, String email, LocalDateTime createdAt) {

    public EmployeeDTO(Employee employee){
        this(employee.getId(), employee.getName(), employee.getEmail(), employee.getCreatedDate());
    }
}
