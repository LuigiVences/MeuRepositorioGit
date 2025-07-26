package com.TCC.SistemaPaese.models.entities;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "records")
public class Record extends BasicAttributes{
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


}
