package com.myback.shared.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.myback.shared.exceptions.DataNotFoundException;
import com.myback.shared.exceptions.InvalidArgumentException;
import com.myback.shared.exceptions.UnhandledException;
import com.myback.shared.exceptions.ValidationException;

@RestControllerAdvice
public class GlobalRestControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(GlobalRestControllerAdvice.class);

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(InvalidArgumentException e) {
        logger.error("Exception thrown: " + e.toString());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.toMap());
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> handleDataNotFoundException(DataNotFoundException e) {
        logger.error("Exception thrown: " + e.toString());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.toMap());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException e) {
        logger.error("Exception thrown: " + e.toString());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.toMap());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUnhandledException(Exception e, WebRequest request) {
        logger.error("Unhandled exception thrown: " + e.toString());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new UnhandledException(null).toMap());
    }

}
