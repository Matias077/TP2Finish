package org.ejemplo.exceptions;

import org.springframework.http.HttpStatus;

public class ProductoException extends Exception {
    private HttpStatus statusCode;
    private String causa;

    public ProductoException(HttpStatus status, String message, String cause) {
        super(message);
        this.causa = cause;
        this.statusCode = status;
    }
    public HttpStatus getStatus(){
        return statusCode;
    }
}
