CREATE TABLE organizational_units(
id SERIAL,
name VARCHAR(255) NOT NULL,
parent_id INTEGER,
type VARCHAR (70) NOT NULL,
active BOOLEAN DEFAULT TRUE NOT NULL,
creation_date TIMESTAMP NOT NULL,
created_by_id INTEGER NOT NULL,
deactivation_date TIMESTAMP,
deactivated_by_id INTEGER,
CONSTRAINT pk_organizational_unit PRIMARY KEY(id),
CONSTRAINT fk_organizational_unit_created_by FOREIGN KEY(created_by_id) REFERENCES employees(id),
CONSTRAINT fk_organizational_unit_deactivated_by FOREIGN KEY(deactivated_by_id) REFERENCES employees(id),
CONSTRAINT fk_parent FOREIGN KEY(parent_id) REFERENCES organizational_unit(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE

);

CREATE INDEX idx_organizational_unit_parent_id ON organizational_unit(parent_id);