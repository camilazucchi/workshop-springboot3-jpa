package com.project.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    // Mensagem padrão da exceção personalizada:
    public ResourceNotFoundException(Object id) {
        super("Resource not found. ID: " + id);
    }


}
