package com.prosigliere.exceptions;

import com.prosigliere.domain.model.Error;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({BlogPostNotFoundException.class})
    public Error handleValidationExceptions(
            BlogPostNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put(HttpStatus.NOT_FOUND.name(), ex.getMessage());

        return Error.builder()
                .timestamp(LocalDateTime.now())
                .errors(errors)
                .build();
    }
}
