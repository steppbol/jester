CREATE TABLE IF NOT EXISTS notes
(
    id           uuid                     NOT NULL,
    version      bigint                   NOT NULL,
    name         text                     NOT NULL,
    context      text                     NOT NULL,
    description  text,
    created_date timestamp with time zone NOT NULL,
    updated_date timestamp with time zone NOT NULL,
    CONSTRAINT notes_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS attributes
(
    id      uuid   NOT NULL,
    version bigint NOT NULL,
    note_id uuid   NOT NULL,
    name    text   NOT NULL,
    value   text   NOT NULL,
    CONSTRAINT attributes_pk PRIMARY KEY (id),
    CONSTRAINT notes_fk FOREIGN KEY (note_id) REFERENCES notes (id)
);