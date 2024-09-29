package com.myback.shared.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnhandledException extends CustomException {

    public UnhandledException(String m) {
        super("Unhandled exception! Please try again later or contact the admin...",
                UnhandledException.class.getSimpleName());
    }

}
