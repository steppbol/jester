package com.home.jester.service;

import com.home.jester.entity.Note;

import java.util.UUID;

public interface NoteService {
    UUID create(Note note);

    Note update(UUID id, Note note);

    Note get(UUID id);

    void delete(UUID id);
}
