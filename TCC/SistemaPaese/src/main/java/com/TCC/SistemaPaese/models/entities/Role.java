package com.TCC.SistemaPaese.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BasicAttributes{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id", nullable = false)
    private Employee createdBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deactivated_by_id")
    private Employee deactivatedBy;
}
