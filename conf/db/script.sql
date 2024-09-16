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
