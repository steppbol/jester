package com.home.jester.repository;

import com.home.jester.entity.Note;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CustomNoteRepository {
    Mono<Note> getById(UUID id);
}
