package com.myback.shared.exceptions;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {
    private String exception;

    public CustomException(String m, String e) {
        super(m);
        this.exception = e;
    }

    public String toString() {
        return String.format("{ message: %s, exception: %s}", this.getMessage(), this.getException());
    }

    public Map<String, ?> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("message", this.getMessage());
        map.put("exception", this.getException());

        return map;
    }
}
