package com.TCC.SistemaPaese.models.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee_roles")
public class EmployeeRole {

    @EmbeddedId
    private EmployeeRoleId id;
    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
    @Column(name = "active", nullable = false)
    private boolean active = true;
    @CreationTimestamp
    @Column(name = "granted_at", nullable = false)
    private LocalDateTime grantedAt;
    @Column(name = "revoked_at")
    private LocalDateTime revokedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "granted_by", nullable = false)
    private Employee grantedBy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "revoked_by")
    private Employee revokedBy;

    protected EmployeeRole(){}

    private EmployeeRole(Employee employee, Role role, Employee grantedBy){
        this.employee = employee;
        this.role = role;
        this.grantedBy = grantedBy;
    }

    public EmployeeRoleId getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Role getRole() {
        return role;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDateTime getGrantedAt() {
        return grantedAt;
    }

    public LocalDateTime getRevokedAt() {
        return revokedAt;
    }

    public Employee getGrantedBy() {
        return grantedBy;
    }

    public Employee getRevokedBy() {
        return revokedBy;
    }

    public void deactivation(Employee revokedBy){
        this.revokedBy = revokedBy;
        this.revokedAt = LocalDateTime.now();
        this.active = false;
    }
}
