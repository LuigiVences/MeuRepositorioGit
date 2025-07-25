package com.TCC.SistemaPaese.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeeRoleId implements Serializable {

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "role_id")
    private Long roleId;

    public EmployeeRoleId() {
    }

    public EmployeeRoleId(Long employeeId, Long roleId) {
        this.employeeId = employeeId;
        this.roleId = roleId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getRoleId() {
        return roleId;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof EmployeeRoleId)) return false;
        EmployeeRoleId that = (EmployeeRoleId) obj;
        return Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId,roleId);
    }
}
