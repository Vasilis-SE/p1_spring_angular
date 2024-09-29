package com.myback.shared.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataNotFoundException extends CustomException {

    public DataNotFoundException(String m) {
        super((m != null && !m.isEmpty()) ? m : "Could not find the requested data!",
                DataNotFoundException.class.getSimpleName());
    }

}
