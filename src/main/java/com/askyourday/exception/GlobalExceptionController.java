package com.askyourday.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

//@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleAllException(Exception ex) {
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(InternalErrorException.class)
    public @ResponseBody ResponseEntity handleInternalErrorException(HttpServletResponse response) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
