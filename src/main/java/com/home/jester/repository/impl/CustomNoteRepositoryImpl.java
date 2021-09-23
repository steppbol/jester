package com.home.jester.repository.impl;

import com.home.jester.entity.Note;
import com.home.jester.repository.CustomNoteRepository;
import com.home.jester.util.NoteMapper;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.UUID;

public class CustomNoteRepositoryImpl implements CustomNoteRepository {
    private final DatabaseClient client;

    public CustomNoteRepositoryImpl(DatabaseClient client) {
        this.client = client;
    }

    @Override
    public Mono<Note> getById(UUID id) {
        var statement = """
                SELECT notes.id AS note_id, notes.name AS note_name, notes.context AS note_context,
                       notes.description AS note_description, notes.created_date AS note_created_date,
                       notes.updated_date AS note_updated_date, attributes.id AS attribute_id,
                       attributes.name AS attribute_name, attributes.value AS attribute_value
                FROM notes INNER JOIN attributes ON notes.id = attributes.note_id
                WHERE notes.id = :id
                """;

        return client.sql(statement)
                .bind("id", id)
                .map(new NoteMapper())
                .all()
                .reduceWith(() -> Note.builder()
                                .attributes(new ArrayList<>())
                                .build(),
                        (accumulator, value) -> {
                            accumulator.setId(value.getId());
                            accumulator.setName(value.getName());
                            accumulator.setContext(value.getContext());
                            accumulator.setDescription(value.getDescription());
                            accumulator.setCreatedDate(value.getCreatedDate());
                            accumulator.setUpdatedDate(value.getUpdatedDate());
                            accumulator.getAttributes().addAll(value.getAttributes());
                            return accumulator;
                        });
    }
}
