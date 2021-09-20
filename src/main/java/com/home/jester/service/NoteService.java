package com.home.jester.service;

import com.home.jester.entity.Note;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface NoteService {
    Mono<Note> create(Mono<Note> note);

    Mono<Note> update(UUID id, Mono<Note> note);

    Mono<Note> get(UUID id);

    Mono<Void> delete(UUID id);
}
