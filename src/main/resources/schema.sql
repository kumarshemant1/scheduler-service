CREATE TABLE IF NOT EXISTS holidays (
    id SERIAL PRIMARY KEY,
    holiday_date DATE NOT NULL,
    description VARCHAR(255)
);

INSERT INTO holidays (holiday_date, description) VALUES
('2025-01-01', 'New Year''s Day'),
('2025-08-15', 'Independence Day');