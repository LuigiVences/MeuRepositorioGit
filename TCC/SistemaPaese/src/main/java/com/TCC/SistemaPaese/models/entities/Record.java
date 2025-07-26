package com.TCC.SistemaPaese.models.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "records")
public class Record extends BasicAttributes{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "incident_id", nullable = false)
    private Incidents incidents;
    @Column(name = "number_of_bus", nullable = false)
    private Integer numberOfBus;
    @Column(name = "hour_local", nullable = false)
    private LocalTime hourLocal;
    @Column(name = "record_type", nullable = false)
    private String recordType;
    @Column(name = "note")
    private String note;
    @ManyToOne
    @JoinColumn(name = "created_by_id", nullable = false)
    private Employee createdBy;
    @ManyToOne
    @JoinColumn(name = "deactivated_by_id")
    private Employee deactivatedBy;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @ManyToOne
    @JoinColumn(name = "updated_by_id")
    private Employee updatedBy;

    protected Record(){}

    public Record(Incidents incidents, Integer numberOfBus, LocalTime hourLocal, String recordType,
                  String note, Employee createdBy){
        this.incidents = incidents;
        this.numberOfBus = numberOfBus;
        this.hourLocal = hourLocal;
        this.recordType = recordType;
        this.note = note;
        this.createdBy = createdBy;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Incidents getIncidents() {
        return incidents;
    }

    public Integer getNumberOfBus() {
        return numberOfBus;
    }

    public LocalTime getHourLocal() {
        return hourLocal;
    }

    public String getRecordType() {
        return recordType;
    }

    public String getNote() {
        return note;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public Employee getDeactivatedBy() {
        return deactivatedBy;
    }

    public void setIncidents(Incidents incidents) {
        this.incidents = incidents;
    }

    public void setNumberOfBus(Integer numberOfBus) {
        this.numberOfBus = numberOfBus;
    }

    public void setHourLocal(LocalTime hourLocal) {
        this.hourLocal = hourLocal;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public Employee getUpdatedBy() {
        return updatedBy;
    }

    public void setDeactivatedBy(Employee deactivatedBy) {
        this.deactivatedBy = deactivatedBy;
    }

    public void setLastUpdate() {
        this.lastUpdate = LocalDateTime.now();
    }

    public void setUpdatedBy(Employee updatedBy) {
        this.updatedBy = updatedBy;
    }
}
