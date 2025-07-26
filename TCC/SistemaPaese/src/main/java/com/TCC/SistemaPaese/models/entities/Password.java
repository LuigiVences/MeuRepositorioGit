package com.TCC.SistemaPaese.models.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "passwords")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
    @CreationTimestamp
    @Column(name = "changed_at", nullable = false)
    private LocalDateTime changedAt;
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    protected Password(){}

    public Password(String passwordHash, Employee employee){
        this.passwordHash = passwordHash;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }
}
