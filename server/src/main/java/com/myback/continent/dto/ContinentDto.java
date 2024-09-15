package com.myback.continent.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContinentDto {
    private int continent_id;

    @NotBlank(message = "The value must not be null and must contain at least one non-whitespace character.")
    @Size(min = 3, max = 20, message = "The value must be between 3 and 20 characters.")
    private String name;
}
