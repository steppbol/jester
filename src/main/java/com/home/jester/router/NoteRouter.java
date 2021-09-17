package com.home.jester.router;

import com.home.jester.handler.NoteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class NoteRouter {
    @Bean
    public RouterFunction<ServerResponse> route(NoteHandler noteHandler) {
        return RouterFunctions.route()
                .POST("/notes", accept(APPLICATION_JSON), noteHandler::create)
                .PUT("/notes/{id}", accept(APPLICATION_JSON), noteHandler::update)
                .GET("/notes/{id}", accept(APPLICATION_JSON), noteHandler::get)
                .DELETE("/notes/{id}", accept(APPLICATION_JSON), noteHandler::delete)
                .build();
    }
}
