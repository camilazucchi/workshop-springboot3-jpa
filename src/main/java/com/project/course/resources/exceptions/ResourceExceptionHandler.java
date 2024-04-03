package com.project.course.resources.exceptions;

import com.project.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
/* A anotação "@ControllerAdvice" permite centralizar o tratamento de exceções e a aplicação de configurações
 * globais em classes de controle (controllers) em uma aplicação Spring MVC.
 * Quando anotamos uma classe com essa anotação, ela se torna um "Advice", ou seja, uma classe que fornece conselhos e
 * comportamentos adicionais para as classes de controle em nossa aplicação. */
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

}
