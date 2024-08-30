package com.myback.shared.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

import org.springframework.validation.ObjectError;

import java.util.HashMap;

@Getter
@Setter
public class ValidationException extends CustomException {
    private List<ObjectError> errors;

    public ValidationException(String m, List<ObjectError> err) {
        super("Error occurred while validating data...", ValidationException.class.getSimpleName());
        this.errors = err;
    }

    @Override
    public String toString() {
        return String.format("{ message: %s, exception: %s, errors: %s }",
                this.getMessage(), this.getException(), this.errors.toString());
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();

        map.put("message", this.getMessage());
        map.put("exception", this.getException());
        map.put("errors", this.getErrors());

        return map;
    }

}
