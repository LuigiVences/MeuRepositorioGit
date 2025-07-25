package com.TCC.SistemaPaese.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

import javax.annotation.processing.Generated;

@MappedSuperclass
public abstract class BasicAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "active", nullable = false)
    protected Boolean active = true;
    @CreationTimestamp
    @Column(name = "creation_date", nullable = false)
    protected LocalDateTime createdDate;
    @Column(name = "deactivation_date")
    protected LocalDateTime deactivationDate;

    protected BasicAttributes() {
    }


    public Long getId() {
        return id;
    }

    public Boolean getActive() {
        return active;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getDeactivationDate() {
        return deactivationDate;
    }

    public void deactivate(){
        this.active = false;
        this.deactivationDate = LocalDateTime.now();
    }
}
