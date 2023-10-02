package com.alura.api.model.infra.errors;

import com.alura.api.model.topic.validators.IntegrityValidator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(IntegrityValidator.class)
    public ResponseEntity<String> handleIntegrityViolationException(IntegrityValidator ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
