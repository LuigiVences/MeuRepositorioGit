CREATE TABLE employee_roles (
employee_id INTEGER,
role_id INTEGER,
active BOOLEAN DEFAULT TRUE NOT NULL,
granted_at TIMESTAMP NOT NULL,
granted_by INTEGER NOT NULL,
revoked_by INTEGER,
revoked_at TIMESTAMP,
CONSTRAINT pk_employee_roles PRIMARY KEY(employee_id, role_id),
CONSTRAINT fk_employee_roles_employee_id FOREIGN KEY(employee_id) REFERENCES employees(id),
CONSTRAINT fk_employee_roles_role_id FOREIGN KEY(role_id) REFERENCES roles(id),
CONSTRAINT fk_granted_by FOREIGN KEY(granted_by) REFERENCES employees(id),
CONSTRAINT fk_revoked_by FOREIGN KEY(revoked_by) REFERENCES employees(id)

);