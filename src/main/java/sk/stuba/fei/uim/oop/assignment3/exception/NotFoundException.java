package sk.stuba.fei.uim.oop.assignment3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {
    public NotFoundException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}