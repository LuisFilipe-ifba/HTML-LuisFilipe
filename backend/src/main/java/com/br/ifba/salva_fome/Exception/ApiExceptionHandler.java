package com.br.ifba.salva_fome.Exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler{

    @Value(value = "${server.error.include-exception}")
    private boolean printStackTrace;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ValidationExceptionResponse> handleMethodArgumentNotValid(
            MethodArgumentNotValidException methodArgumentNotValidException) {

        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();

        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fieldMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        ValidationExceptionResponse response = new ValidationExceptionResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage("Erro de validação");
        response.setTitle("Bad Request Exception - Campos inválidos");
        response.setDetails("Verifique os campos obrigatórios");
        response.setDeveloperMessage(methodArgumentNotValidException.getClass().getName());
        response.setFields(fields);
        response.setFieldMessages(fieldMessages);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}

