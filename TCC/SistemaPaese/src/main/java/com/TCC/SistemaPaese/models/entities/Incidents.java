package com.TCC.SistemaPaese.models.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "incidents")
public class Incidents extends BasicAttributes {

    @Column(name = "indicent_number", nullable = false)
    private Integer incidentNumber;
    @Column(name = "date_incident", nullable = false)
    private LocalDate dateIncident;
    @ManyToOne
    @JoinColumn(name = "organizational_unit_id", nullable = false)
    private OrganizationalUnit organizationalUnit;
    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private Employee createdBy;
    @ManyToOne
    @JoinColumn(name = "deactivated_by", nullable = false)
    private Employee deactivatedBy;
    @Column(name = "finished", nullable = false)
    private Boolean finished = false;
    @Column(name = "completed_on")
    private LocalDateTime completedOn;
    @ManyToOne
    @JoinColumn(name = "completed_by")
    private Employee completedBy;
    @OneToMany(mappedBy = "incidents", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Record> records = new ArrayList<>();

    protected Incidents(){}

    public Incidents(Integer incidentNumber, LocalDate dateIncident, OrganizationalUnit organizationalUnit){
        this.incidentNumber = incidentNumber;
        this.dateIncident = dateIncident;
        this.organizationalUnit = organizationalUnit;
    }

    public Integer getIncidentNumber() {
        return incidentNumber;
    }

    public LocalDate getDateIncident() {
        return dateIncident;
    }

    public OrganizationalUnit getOrganizationalUnit() {
        return organizationalUnit;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public Employee getDeactivatedBy() {
        return deactivatedBy;
    }

    public Boolean getFinished() {
        return finished;
    }

    public LocalDateTime getCompletedOn() {
        return completedOn;
    }

    public Employee getCompletedBy() {
        return completedBy;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }

    public void setIncidentNumber(Integer incidentNumber) {
        this.incidentNumber = incidentNumber;
    }

    public void setDateIncident(LocalDate dateIncident) {
        this.dateIncident = dateIncident;
    }

    public void setOrganizationalUnit(OrganizationalUnit organizationalUnit) {
        this.organizationalUnit = organizationalUnit;
    }

    public void setDeactivatedBy(Employee deactivatedBy) {
        this.deactivatedBy = deactivatedBy;
    }

    public void incidentFinished(Employee completedBy){
        this.completedBy = completedBy;
        this.completedOn = LocalDateTime.now();
        this.finished = true;
    }
}
