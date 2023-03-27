package com.goal.merchantsimulator.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
@RestController
public class HandleApiException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> handleApiException(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> mapError = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((FieldError error) ->
                mapError.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(new ValidationError("200", "Validation Errors", "Validation Errors",mapError), HttpStatus.OK);
    }

}
