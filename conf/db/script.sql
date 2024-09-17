CREATE TABLE SEGMENT (
                         id SERIAL PRIMARY KEY,
                         segment_number INT NOT NULL UNIQUE,
                         nomenclature VARCHAR(255) NOT NULL,
                         length FLOAT NOT NULL,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_segment_number ON SEGMENT(segment_number);

CREATE TABLE CURB (
                      id SERIAL PRIMARY KEY,
                      segment_id INT NOT NULL REFERENCES SEGMENT(id) ON DELETE CASCADE,
                      material VARCHAR(255) NOT NULL,
                      length FLOAT NOT NULL,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ROAD (
                      id SERIAL PRIMARY KEY,
                      segment_id INT NOT NULL REFERENCES SEGMENT(id) ON DELETE CASCADE,
                      pavement_type VARCHAR(255) NOT NULL,
                      length FLOAT NOT NULL,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



INSERT INTO SEGMENT (segment_number, nomenclature, length)
VALUES (101, 'Avenida 1', 120.5);

INSERT INTO SEGMENT (segment_number, nomenclature, length)
VALUES (102, 'Calle 2', 200.0);

INSERT INTO SEGMENT (segment_number, nomenclature, length)
VALUES (103, 'Carrera 3', 350.75);

INSERT INTO SEGMENT (segment_number, nomenclature, length)
VALUES (104, 'Diagonal 4', 450.0);

INSERT INTO SEGMENT (segment_number, nomenclature, length)
VALUES (105, 'Transversal 5', 300.5);

INSERT INTO CURB (segment_id, material, length)
VALUES (1, 'Concrete', 60.25);

INSERT INTO CURB (segment_id, material, length)
VALUES (2, 'Asphalt', 100.0);

INSERT INTO CURB (segment_id, material, length)
VALUES (3, 'Granite', 175.5);

INSERT INTO CURB (segment_id, material, length)
VALUES (4, 'Concrete', 225.0);

INSERT INTO CURB (segment_id, material, length)
VALUES (5, 'Brick', 150.5);

INSERT INTO ROAD (segment_id, pavement_type, length)
VALUES (1, 'Asphalt', 120.5);

INSERT INTO ROAD (segment_id, pavement_type, length)
VALUES (2, 'Concrete', 200.0);

INSERT INTO ROAD (segment_id, pavement_type, length)
VALUES (3, 'Asphalt', 350.75);

INSERT INTO ROAD (segment_id, pavement_type, length)
VALUES (4, 'Granite', 450.0);

INSERT INTO ROAD (segment_id, pavement_type, length)
VALUES (5, 'Asphalt', 300.5);
