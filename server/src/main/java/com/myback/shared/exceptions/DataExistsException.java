package com.myback.shared.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataExistsException extends CustomException {

    public DataExistsException(String m) {
        super((m != null && !m.isEmpty()) ? m : "Data already exists!",
                DataExistsException.class.getSimpleName());
    }

}
