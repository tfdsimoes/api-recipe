package com.getdrop.recipe.common.controller;

import com.getdrop.recipe.common.exception.ElementNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(value = ElementNotFoundException.class)
  protected ResponseEntity<String> handleElementNotFound(RuntimeException ex) {
    log.error("[RestController] {}: {}", ex.getClass().getSimpleName(), ex.getMessage(), ex);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }
}
