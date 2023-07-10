package br.com.compassuol.pb.challenge.exception;

import org.springframework.http.HttpStatus;

public class ProductMsException extends  RuntimeException{

    private HttpStatus status;
    private String message;

    public ProductMsException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ProductMsException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
