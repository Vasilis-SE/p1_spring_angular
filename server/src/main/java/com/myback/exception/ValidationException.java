package com.myback.exception;

import lombok.Getter;
import lombok.Setter;
import scala.collection.mutable.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.validation.ObjectError;

@Getter
@Setter
public class ValidationException extends CustomException {
    private List<String> errors;

    public ValidationException(String m) {
        super("Error occurred while validating data...", ValidationException.class.getSimpleName());
    }

    @Override
    public String toString() {
        return String.format("{ message: %s, exception: %s, errors: %s }", 
            this.getMessage(), this.getException(), this.errors.toString());
    }


    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("message", this.getMessage());
        map.put("exception",  this.getException());
        map.put("errors", this.getErrors());

        return map;
    }

}
