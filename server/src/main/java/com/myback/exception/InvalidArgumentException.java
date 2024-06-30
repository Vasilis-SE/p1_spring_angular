package com.myback.exception;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidArgumentException extends CustomException {
    private String argument;
    private String value;
    private String expected;

    public InvalidArgumentException(String m, String a, String v, String e) {
        super((m != null && !m.isEmpty()) ? m : "Invalid argument provided!", InvalidArgumentException.class.getSimpleName());
        this.argument = a;
        this.value = v;
        this.expected = e;
    }

    @Override
    public String toString() {
        return String.format("{ message: %s, exception: %s, argument: %s, value: %s, expected: %s}", 
            this.getMessage(), this.getException(), this.getArgument(), this.getValue(), this.getExpected());
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>(); 
        map.put("message", this.getMessage());
        map.put("exception", this.getException());
        map.put("argument", this.getArgument());
        map.put("value", this.getValue());
        map.put("expected", this.getExpected());

        return map;
    }
}
