package com.home.jester.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;

@Log4j2
@RestControllerAdvice
public final class ControllerAdvice {
    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String runtimeException(RuntimeException e, WebRequest request) {
        log.error("ERROR: {}", e.getMessage());
        e.printStackTrace();
        return e.getMessage();
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String entityNotFoundException(RuntimeException e, WebRequest request) {
        log.error("ERROR: {}", e.getMessage());
        e.printStackTrace();
        return e.getMessage();
    }
}
