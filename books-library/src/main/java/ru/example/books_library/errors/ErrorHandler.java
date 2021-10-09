package ru.example.books_library.errors;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
@Slf4j
public class ErrorHandler {

//    @ExceptionHandler(TaskException.class)
//    public ResponseEntity<ErrorResponse> taskExceptionHandler(TaskException e) {
//        ErrorResponse response = new ErrorResponse(e.getTimestamp(), e.getCode(), e.getMeassage());
//        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String message = String.format(e.getBindingResult().getFieldError().getDefaultMessage(),
                e.getBindingResult().getFieldError().getField());
        log.error(String.format("%s. %s", "validateFields", message));
        ErrorResponse response = new ErrorResponse(new Date().getTime(), HttpStatus.UNPROCESSABLE_ENTITY.value(), message,null);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> bookNotFound(NotFoundException e) {
        ErrorResponse response = new ErrorResponse(new Date().getTime(), HttpStatus.NOT_FOUND.value(), e.getMessage(),null);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }
//
//    @ExceptionHandler(IncorrectFormatException.class)
//    public ResponseEntity<ErrorResponseFull> validationExceptionHandler(IncorrectFormatException e) {
//        ErrorResponseFull response = new ErrorResponseFull(DateTime.now().getMillis(), e.getErrorCode(), e.getMessage(), e.getVariables());
//        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> allExceptionHandler(Exception e) {
//        e.printStackTrace();
//        ErrorResponse response = new ErrorResponse(DateTime.now().getMillis(), HttpStatus.SERVICE_UNAVAILABLE.value(), e.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
//    }
}
