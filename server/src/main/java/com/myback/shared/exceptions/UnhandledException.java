package com.myback.shared.exceptions;


import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnhandledException extends CustomException {
    
    public UnhandledException(String m) {
        super("Unhandled exception! Please try again later or contact the admin...", UnhandledException.class.getSimpleName());
    }

    @Override
    public String toString() {
        return String.format("{ message: %s, exception: %s }", this.getMessage(), this.getException());
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>(); 
        map.put("message", this.getMessage());
        map.put("exception", this.getException());

        return map;
    }
}
