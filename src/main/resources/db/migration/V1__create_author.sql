CREATE TABLE author (
    id          BIGSERIAL PRIMARY KEY,
    email       VARCHAR(255),
    name        VARCHAR(255),
    description VARCHAR(400),
    registration_date TIMESTAMP WITH TIME ZONE
);
