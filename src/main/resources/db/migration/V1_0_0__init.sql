create table if not exists 'notes' (
    id uuid not null default uuid_generate_v4(),
    name not null text,
    context not null text,
    description text,
    createdDate timestamp without time zone,
    updatedDate timestamp without time zone,
    constraint notes_pkey primary key (id)
)

create table if not exists 'attributes' (
    id uuid not null default uuid_generate_v4(),
    id uuid not null,
    name not null text,
    value not null text,
    constraint attributes_pkey primary key (id)
)