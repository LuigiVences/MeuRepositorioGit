CREATE TABLE passwords (
id SERIAL,
password_hash VARCHAR NOT NULL,
changed_at TIMESTAMP NOT NULL,
employee_id INTEGER NOT NULL,
CONSTRAINT pk_passwords PRIMARY KEY(id),
CONSTRAINT fk_passwords_employees_password FOREIGN KEY(employee_id) REFERENCES employees(id)

);