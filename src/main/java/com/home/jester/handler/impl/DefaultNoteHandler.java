package com.home.jester.handler.impl;

import com.home.jester.entity.Note;
import com.home.jester.handler.NoteHandler;
import com.home.jester.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class DefaultNoteHandler implements NoteHandler {
    private final NoteService noteService;

    @Autowired
    public DefaultNoteHandler(NoteService noteService) {
        this.noteService = noteService;
    }

    @Override
    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        return noteService.create(serverRequest.bodyToMono(Note.class))
                .flatMap(note ->
                        ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(note))
                .switchIfEmpty(notFound().build())
                .onErrorResume(error ->
                        ServerResponse
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .bodyValue(error.getMessage()));
    }

    @Override
    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        return noteService.update(UUID.fromString(serverRequest.pathVariable("id")), serverRequest.bodyToMono(Note.class))
                .flatMap(note ->
                        ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(note))
                .switchIfEmpty(notFound().build())
                .onErrorResume(error ->
                        ServerResponse
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .bodyValue(error.getMessage()));
    }

    @Override
    public Mono<ServerResponse> get(ServerRequest serverRequest) {
        return noteService.get(UUID.fromString(serverRequest.pathVariable("id")))
                .flatMap(note ->
                        ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(note))
                .switchIfEmpty(notFound().build())
                .onErrorResume(error ->
                        ServerResponse
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .bodyValue(error.getMessage()));
    }

    @Override
    public Mono<ServerResponse> delete(ServerRequest serverRequest) {
        return noteService.delete(UUID.fromString(serverRequest.pathVariable("id")))
                .flatMap(note ->
                        ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .build())
                .onErrorResume(error ->
                        ServerResponse
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .bodyValue(error.getMessage()));
    }
}
