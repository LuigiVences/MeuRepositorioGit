package com.TCC.SistemaPaese.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organizational_units")
public class OrganizationalUnit extends BasicAttributes{

    @Size(max = 255)
    @Column(length = 255, name = "name", nullable = false)
    private String name;
    @Size(max = 70)
    @Column(length = 70, name = "type", nullable = false)
    private String type;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private OrganizationalUnit parent;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id", nullable = false)
    private Employee createdBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deactivated_by_id")
    private Employee deactivatedBy;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<OrganizationalUnit> children = new ArrayList<>();

    protected OrganizationalUnit(){}

    public OrganizationalUnit(String name, String type, OrganizationalUnit parent){
        this.name = name;
        this.type = type;
        this.parent = parent;
    }

    public String  getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public OrganizationalUnit getParent(){
        return parent;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setType(String type){
        this.type = type;
    }

}
