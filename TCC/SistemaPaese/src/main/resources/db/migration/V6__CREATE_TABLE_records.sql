CREATE TABLE records(
id SERIAL,
incident_id INTEGER NOT NULL,
number_of_bus INTEGER NOT NULL,
hour_local TIME NOT NULL,
record_type VARCHAR(10) NOT NULL,
active BOOLEAN DEFAULT TRUE NOT NULL,
creation_date TIMESTAMP NOT NULL,
created_by_id INTEGER NOT NULL,
deactivated_by_id INTEGER,
deactivation_date DATE,
last_update TIMESTAMP,
updated_by_id INTEGER,
CONSTRAINT pk_records PRIMARY KEY(id),
CONSTRAINT fk_records_incident FOREIGN KEY(incident_id) REFERENCES incidents(id),
CONSTRAINT fk_records_created_by FOREIGN KEY(created_by_id) REFERENCES employees(id),
CONSTRAINT fk_records_deactivated_by FOREIGN KEY(deactivated_by_id) REFERENCES employees(id),
CONSTRAINT fk_records_updated_by FOREIGN KEY(updated_by_id) REFERENCES employees(id)

);