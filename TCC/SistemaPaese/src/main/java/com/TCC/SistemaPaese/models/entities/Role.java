package com.TCC.SistemaPaese.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "roles")
public class Role extends BasicAttributes{

    @Size(max = 100)
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id", nullable = false)
    private Employee createdBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deactivated_by_id")
    private Employee deactivatedBy;

    protected Role(){}

    public Role(String name, String description, Employee createdBy){
        this.name = name;
        this.description = description;
        this.createdBy = createdBy;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Employee getCreation(){
        return createdBy;
    }

}
