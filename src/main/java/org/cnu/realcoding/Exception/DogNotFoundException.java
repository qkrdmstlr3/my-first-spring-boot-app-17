package org.cnu.realcoding.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DogNotFoundException extends RuntimeException{
    public DogNotFoundException() {
    }
    public DogNotFoundException(String message) {
        super(message);
    }
}
