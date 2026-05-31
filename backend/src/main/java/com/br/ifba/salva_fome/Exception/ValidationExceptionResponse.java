package com.br.ifba.salva_fome.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValidationExceptionResponse {

    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String title;
    private String details;
    private String developerMessage;
    private String fields;
    private String fieldMessages;
}

