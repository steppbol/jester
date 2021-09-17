package com.home.jester.service.impl;

import com.home.jester.entity.Note;
import com.home.jester.service.NoteService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DefaultNoteService implements NoteService {
    @Override
    public Mono<Note> create(Mono<Note> bodyToMono) {
        return null;
    }

    @Override
    public Mono<Note> update(Integer id, Mono<Note> bodyToMono) {
        return null;
    }

    @Override
    public Mono<Note> get(Integer id, Mono<Note> bodyToMono) {
        return null;
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return null;
    }
}
