CREATE TABLE exam(
    id UUID PRIMARY KEY NOT NULL ,
    code VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    status VARCHAR(50) CHECK ( status in ('ACTIVE', 'INACTIVE', 'CANCELLED') )
);