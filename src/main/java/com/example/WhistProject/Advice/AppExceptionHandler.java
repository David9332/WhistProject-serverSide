package com.example.WhistProject.Advice;



import com.example.WhistProject.Exception.UserErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = {UserErrorException.class})
    public ResponseEntity<?> handleExceptions(UserErrorException e) {
        UserErrorException errorMessage = new UserErrorException(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}