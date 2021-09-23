package com.home.jester.util;

import com.home.jester.entity.Attribute;
import com.home.jester.entity.Note;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;

public class NoteMapper implements BiFunction<Row, RowMetadata, Note> {
    @Override
    public Note apply(Row row, RowMetadata rowMetadata) {
        var noteId = row.get("note_id", UUID.class);
        return Note.builder()
                .id(noteId)
                .name(row.get("note_name", String.class))
                .context(row.get("note_context", String.class))
                .description(row.get("note_description", String.class))
                .createdDate(row.get("note_created_date", LocalDateTime.class))
                .updatedDate(row.get("note_updated_date", LocalDateTime.class))
                .attributes(List.of(Attribute.builder()
                        .id(row.get("attribute_id", UUID.class))
                        .noteId(noteId)
                        .name(row.get("attribute_name", String.class))
                        .value(row.get("attribute_value", String.class))
                        .build()))
                .build();
    }
}
