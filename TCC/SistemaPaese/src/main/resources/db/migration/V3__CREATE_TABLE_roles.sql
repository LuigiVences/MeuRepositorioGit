CREATE TABLE roles (
id SERIAL,
name VARCHAR(100) NOT NULL,
description TEXT,
active BOOLEAN DEFAULT TRUE NOT NULL,
creation_date TIMESTAMP NOT NULL,
created_by_id INTEGER NOT NULL,
deactivation_date TIMESTAMP,
deactivated_by_id INTEGER,
CONSTRAINT pk_roles PRIMARY KEY(id),
CONSTRAINT fk_roles_created_by FOREIGN KEY(created_by_id) REFERENCES employees(id),
CONSTRAINT fk_roles_deactivated_by FOREIGN KEY(deactivated_by_id) REFERENCES employees(id)

);