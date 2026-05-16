CREATE TABLE book (
    id              BIGSERIAL PRIMARY KEY,
    title           VARCHAR(255),
    summary         VARCHAR(500),
    index           VARCHAR(255),
    price           NUMERIC(19, 2),
    number_of_pages INTEGER,
    isbn            VARCHAR(255),
    airing_date     DATE,
    category_id     BIGINT REFERENCES category(id),
    author_id       BIGINT REFERENCES author(id)
);
