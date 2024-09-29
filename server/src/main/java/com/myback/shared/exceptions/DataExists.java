package com.myback.shared.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataExists extends CustomException {

    public DataExists(String m) {
        super((m != null && !m.isEmpty()) ? m : "Data already exists!",
                DataExists.class.getSimpleName());
    }

}
