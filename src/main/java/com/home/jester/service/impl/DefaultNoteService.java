package com.home.jester.service.impl;

import com.home.jester.entity.Note;
import com.home.jester.repository.NoteRepository;
import com.home.jester.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class DefaultNoteService implements NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public DefaultNoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Mono<Note> create(Mono<Note> note) {
        return note
                .flatMap(noteRepository::save);
    }

    @Override
    public Mono<Note> update(UUID id, Mono<Note> note) {
        return note
                .doOnNext(e -> e.setId(id))
                .flatMap(noteRepository::save);
    }

    @Override
    public Mono<Note> get(UUID id) {
        return noteRepository.getById(id);
    }

    @Override
    public Mono<Void> delete(UUID id) {
        return noteRepository.deleteById(id);
    }
}
