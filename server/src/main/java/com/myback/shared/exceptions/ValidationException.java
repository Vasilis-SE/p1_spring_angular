package com.myback.shared.exceptions;

import lombok.Getter;
import lombok.Setter;
import java.util.Map;

import com.myback.shared.dto.ValidationErrorDto;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class ValidationException extends CustomException {
    private List<ValidationErrorDto> errors;

    public ValidationException(String m, List<ValidationErrorDto> err) {
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
