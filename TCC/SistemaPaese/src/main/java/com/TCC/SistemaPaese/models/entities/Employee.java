package com.TCC.SistemaPaese.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee extends BasicAttributes{

    @Size(max = 100)
    @Column(name = "name", nullable = false)
    private String name;
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
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Employee> employeeCreatedBy = new ArrayList<>();
    @OneToMany(mappedBy = "deactivatedBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Employee> employeeDeactivatedBy = new ArrayList<>();
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrganizationalUnit> organizationalUnitsCreatedBy = new ArrayList<>();
    @OneToMany(mappedBy = "deactivatedBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrganizationalUnit>organizationalUnitsDeactivatedBy = new ArrayList<>();
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<EmployeeRole> roles = new ArrayList<>();
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Record> recordsEmployeesCreatedBy = new ArrayList<>();
    @OneToMany(mappedBy = "deactivatedBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Record> recordsEmployeesDeactivatedBy = new ArrayList<>();
    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.EAGER)
    private List<Record> recordsUpdatedBy = new ArrayList<>();
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Password password;
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Incidents> incidentsCreatedBy = new ArrayList<>();
    @OneToMany(mappedBy = "deactivatedBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Incidents> incidentsDeactivatedBy = new ArrayList<>();
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> rolesCreatedBy = new ArrayList<>();
    @OneToMany(mappedBy = "deactivatedBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> rolesDeactivatedBy = new ArrayList<>();
    @OneToMany(mappedBy = "completedBy", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Incidents> completedBy = new ArrayList<>();

    protected Employee(){}

    private Employee(String name, String email, Employee createdBy, OrganizationalUnit organizationalUnit){
        this.name = name;
        this.email = email;
        this.createdBy = createdBy;
        this.organizationalUnit = organizationalUnit;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public Employee getDeactivatedBy() {
        return deactivatedBy;
    }

    public OrganizationalUnit getOrganizationalUnit() {
        return organizationalUnit;
    }

    public List<Employee> getEmployeeCreatedBy() {
        return employeeCreatedBy;
    }

    public List<Employee> getEmployeeDeactivatedBy() {
        return employeeDeactivatedBy;
    }

    public List<OrganizationalUnit> getOrganizationalUnitsCreatedBy() {
        return organizationalUnitsCreatedBy;
    }

    public List<OrganizationalUnit> getOrganizationalUnitsDeactivatedBy() {
        return organizationalUnitsDeactivatedBy;
    }

    public List<EmployeeRole> getRoles() {
        return roles;
    }

    public List<Record> getRecordsEmployeesCreatedBy() {
        return recordsEmployeesCreatedBy;
    }

    public List<Record> getRecordsEmployeesDeactivatedBy() {
        return recordsEmployeesDeactivatedBy;
    }

    public List<Record> getRecordsUpdatedBy() {
        return recordsUpdatedBy;
    }

    public Password getPassword() {
        return password;
    }

    public List<Incidents> getIncidentsCreatedBy() {
        return incidentsCreatedBy;
    }

    public List<Incidents> getIncidentsDeactivatedBy() {
        return incidentsDeactivatedBy;
    }

    public List<Role> getRolesCreatedBy() {
        return rolesCreatedBy;
    }

    public List<Role> getRolesDeactivatedBy() {
        return rolesDeactivatedBy;
    }

    public List<Incidents> getCompletedBy() {
        return completedBy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDeactivatedBy(Employee deactivatedBy) {
        this.deactivatedBy = deactivatedBy;
    }
}
