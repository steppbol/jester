CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS notes
(
    id           uuid NOT NULL DEFAULT uuid_generate_v4(),
    name         text NOT NULL,
    context      text NOT NULL,
    description  text,
    created_date TIMESTAMP WITHOUT TIME ZONE,
    updated_date TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT notes_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS attributes
(
    id      uuid NOT NULL DEFAULT uuid_generate_v4(),
    note_id uuid NOT NULL,
    name    text NOT NULL,
    value   text NOT NULL,
    CONSTRAINT attributes_pk PRIMARY KEY (id),
    CONSTRAINT notes_fk FOREIGN KEY (note_id) REFERENCES notes (id)
);