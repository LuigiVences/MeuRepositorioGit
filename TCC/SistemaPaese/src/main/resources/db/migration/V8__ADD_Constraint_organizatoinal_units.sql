ALTER TABLE organizational_units
ADD CONSTRAINT fk_organizational_unit_created_by FOREIGN KEY(created_by_id) REFERENCES employees(id),
ADD CONSTRAINT fk_organizational_unit_deactivated_by FOREIGN KEY(deactivated_by_id) REFERENCES employees(id);
