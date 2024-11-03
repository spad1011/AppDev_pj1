package org.acme.spsp.controller.handlers;

import org.acme.spsp.service.exceptions.NotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleRessourceNotFound(NotFoundException e) {
        ApiError apiError = new ApiError(LocalDateTime.now(), e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleRessourceBadRequest(BadRequestException e) {
        ApiError apiError = new ApiError(LocalDateTime.now(), e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleRessourceMethodArgumentNotValid(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String errorMessage = fieldErrors.stream().map(fieldError ->
                String.format("Field '%s': %s", fieldError.getField(), fieldError.getDefaultMessage())
        ).collect(Collectors.joining("|"));
        ApiError apiError = new ApiError(LocalDateTime.now(), errorMessage, HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> handleRessourceDataIntegrityViolation(DataIntegrityViolationException e) {
        ApiError apiError = new ApiError(LocalDateTime.now(), e.getMessage() + " The request would have caused a conflict. ", HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }
}
