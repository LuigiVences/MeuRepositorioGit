CREATE TABLE incidents (
id SERIAL,
incident_number INTEGER NOT NULL,
date_incident DATE NOT NULL,
organizational_unit_id INTEGER NOT NULL,
active BOOLEAN DEFAULT TRUE NOT NULL,
creation_date TIMESTAMP NOT NULL,
created_by_id INTEGER NOT NULL,
deactivated_by_id INTEGER,
deactivation_date DATE,
finished BOOLEAN DEFAULT FALSE NOT NULL,
CONSTRAINT pk_incidents PRIMARY KEY(id),
CONSTRAINT fk_incidents_organizational_unit FOREIGN KEY(organizational_unit_id) REFERENCES organizational_units(id),
CONSTRAINT fk_incidents_created_by FOREIGN KEY(created_by_id) REFERENCES employees(id),
CONSTRAINT fk_incidents_deactivated_by FOREIGN KEY(deactivated_by_id) REFERENCES employees(id),
CONSTRAINT incidents_unique UNIQUE(incident_number, date_incident, organizational_unit_id)

);