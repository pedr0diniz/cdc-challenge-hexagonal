CREATE TABLE purchaser (
    id           BIGSERIAL PRIMARY KEY,
    email        VARCHAR(255),
    name         VARCHAR(255),
    surname      VARCHAR(255),
    document     VARCHAR(255),
    address_one  VARCHAR(255),
    address_two  VARCHAR(255),
    city         VARCHAR(255),
    country_id   BIGINT REFERENCES country(id),
    state_id     BIGINT REFERENCES state(id),
    zip_code     VARCHAR(255),
    phone_number VARCHAR(255)
);
