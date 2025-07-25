package com.TCC.SistemaPaese.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BasicAttributes {
    @Id
    protected Long id;
    @Column(name = "active", nullable = false)
    protected Boolean active = true;
    @CreationTimestamp
    @Column(name = "creattion_date", nullable = false)
    protected LocalDateTime createdDate;
    @Column(name = "deactivation_date")
    protected LocalDateTime deactivationDate;

    public BasicAttributes() {
    }

    public BasicAttributes(Long id, Boolean active, LocalDateTime createdDate,
                           LocalDateTime deactivationDate) {
        this.id = id;
        this.active = active;
        this.createdDate = createdDate;
        this.deactivationDate = deactivationDate;
    }

    protected Long getId() {
        return id;
    }

    protected Boolean getActive() {
        return active;
    }

    protected LocalDateTime getCreatedDate() {
        return createdDate;
    }

    protected LocalDateTime getDeactivationDate() {
        return deactivationDate;
    }

    protected void setActive(Boolean active) {
        this.active = active;
    }

    protected void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    protected void deactivation(){
        this.active = false;
        this.deactivationDate = LocalDateTime.now();
    }
}
