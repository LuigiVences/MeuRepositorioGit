package com.TCC.SistemaPaese.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee extends BasicAttributes{

    @Size(max = 100)
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id", nullable = false)
    private Employee createdBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deactivated_by_id")
    private Employee deactivatedBy;
    @ManyToOne
    @JoinColumn(name = "organization_unit_id", nullable = false)
    private OrganizationalUnit organizationalUnit;
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<Employee> employeeCreatedBy = new ArrayList<>();
    @OneToMany(mappedBy = "deactivatedBy", cascade = CascadeType.ALL)
    private List<Employee> employeeDeactivatedBy = new ArrayList<>();
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<OrganizationalUnit> organizationalUnitsCreatedBy = new ArrayList<>();
    @OneToMany(mappedBy = "deactivatedBy", cascade = CascadeType.ALL)
    private List<OrganizationalUnit>organizationalUnitsDeactivatedBy = new ArrayList<>();


}
