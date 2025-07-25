package com.TCC.SistemaPaese.models;

import java.time.LocalDate;
import jakarta.persistence.*;

import com.TCC.SistemaPaese.models.entities.BasicAttributes;
import com.TCC.SistemaPaese.models.entities.Employee;
import com.TCC.SistemaPaese.models.entities.OrganizationalUnit;

@Entity
@Table(name = "incidents")
public class Incidents extends BasicAttributes {

    @Column(name = "indicent_number", nullable = false)
    private Integer incidentNumber;
    @Column(name = "date_incident", nullable = false)
    private LocalDate dateIncident;
    @ManytoOne
    @JoinColumn(name = "organizational_unit_id", nullable = false)
    private OrganizationalUnit organizationalUnit;
    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private Employee employeeCreation;
    @ManyToOne
    @JoinColumn(name = "deactivated_by", nullable = false)
    private Employee employeeDeactivation;
    @Column(name = "finished", nullable = false)
    private Boolean finished = false;


    protected Incidentes(){}

    public Incidents(Integer incidentNumber, LocalDate dateIncident, OrganizationalUnit organizationalUnit){
        this.incidentNumber = incidentNumber;
        this.dateIncident = dateIncident;
        this.organizationalUnit = organizationalUnit;
    }

    public Integer getIncidentNumber(){
        return incidentNumber;
    }

    public LocalDate getDate(){
        return dateIncident;
    }

    public OrganizationalUnit geOrganizationalUnit(){
        return organizationalUnit;
    }

}
