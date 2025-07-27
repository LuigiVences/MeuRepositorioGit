CREATE TABLE employees(
id SERIAL,
name VARCHAR (100) NOT NULL,
email VARCHAR (100) NOT NULL,
active BOOLEAN DEFAULT TRUE NOT NULL,
creation_date TIMESTAMP NOT NULL,
created_by_id INTEGER,
deactivation_date TIMESTAMP,
deactivated_by_id INTEGER,
organizational_unit_id INTEGER,
CONSTRAINT pk_employee PRIMARY KEY(id),
CONSTRAINT email_unique UNIQUE(email),
CONSTRAINT fk_employees_organizational_unit FOREIGN KEY(organizational_unit_id) REFERENCES organizational_units(id),
CONSTRAINT fk_employees_created_by FOREIGN KEY(created_by_id) REFERENCES employees(id),
CONSTRAINT fk_employees_deactivated_by FOREIGN KEY(deactivated_by_id) REFERENCES employees(id)

);