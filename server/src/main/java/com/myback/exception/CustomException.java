package com.myback.exception;

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
}
