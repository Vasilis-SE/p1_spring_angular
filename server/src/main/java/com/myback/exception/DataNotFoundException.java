package com.myback.exception;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataNotFoundException extends CustomException {

    public DataNotFoundException(String m) {
        super((m != null && !m.isEmpty()) ? m : "Could not find the requested data!",
                DataNotFoundException.class.getSimpleName());
    }

    @Override
    public String toString() {
        return String.format("{ message: %s, exception: %s}", this.getMessage(), this.getException());
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("message", this.getMessage());
        map.put("exception", this.getException());

        return map;
    }
}
