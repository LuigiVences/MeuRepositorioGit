CREATE TABLE employee_roles (
employee_id INTEGER,
role_id INTEGER REFERENCES role(id),
active BOOLEAN DEFAULT TRUE NOT NULL,
creation_date TIMESTAMP NOT NULL,
created_by_id INTEGER NOT NULL,
deactivated_by_id INTEGER,
deactivation_date DATE,
CONSTRAINT pk_employee_roles PRIMARY KEY(employee_id, role_id),
CONSTRAINT fk_employee_roles_employee_id FOREIGN KEY(employee_id) RERERENCES employees(id),
CONSTRAINT fk_employee_roles_role_id FOREIGN KEY(role_id) RERERENCES roles(id),
CONSTRAINT fk_employee_roles_created_by FOREIGN KEY(created_by_id) RERERENCES employees(id),
CONSTRAINT fk_employee_roles_deactivated_by FOREIGN KEY(deactivated_by_id) RERERENCES employees(id)

);