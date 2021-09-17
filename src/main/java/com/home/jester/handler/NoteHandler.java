package com.home.jester.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface NoteHandler {
    Mono<ServerResponse> create(ServerRequest serverRequest);

    Mono<ServerResponse> update(ServerRequest serverRequest);

    Mono<ServerResponse> get(ServerRequest serverRequest);

    Mono<ServerResponse> delete(ServerRequest serverRequest);
}
