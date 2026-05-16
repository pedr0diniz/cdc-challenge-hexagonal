CREATE TABLE state (
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255),
    country_id BIGINT REFERENCES country(id)
);
