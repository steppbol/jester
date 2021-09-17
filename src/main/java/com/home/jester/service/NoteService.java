package com.home.jester.service;

import com.home.jester.entity.Note;
import reactor.core.publisher.Mono;

public interface NoteService {
    Mono<Note> create(Mono<Note> bodyToMono);

    Mono<Note> update(Integer id, Mono<Note> bodyToMono);

    Mono<Note> get(Integer id, Mono<Note> bodyToMono);

    Mono<Void> delete(Integer id);
}
