package com.myback.continent.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateContinentDto {

    @NotBlank(message = "This value cannot be empty")
    @Size(min = 3, max = 20, message = "The value must be between 3 and 20 characters")
    private String name;
    
}
