package com.myback.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.myback.exception.InvalidArgumentException;

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
}
