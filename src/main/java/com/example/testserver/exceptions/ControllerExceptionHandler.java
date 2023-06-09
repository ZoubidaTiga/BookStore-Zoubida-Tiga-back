package com.example.testserver.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorMessage> BookNotFoundException(BookNotFoundException ex,
                                                              WebRequest request){
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(PostArgumentNotValidException.class)
    public ResponseEntity<String> postErrorMessageResponseEntity(
            PostArgumentNotValidException pEx)
    {
        return ResponseEntity.badRequest().body(pEx.getMessage ());
    }

}
