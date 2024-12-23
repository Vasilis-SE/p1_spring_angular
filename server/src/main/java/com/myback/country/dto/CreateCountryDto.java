package com.myback.country.dto;

import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCountryDto {

    @NotNull(message = "This value cannot be null")
    @Min(value = 1, message = "This field must contain a positive continent id")
    private Integer regionId;

    @NotBlank(message = "This value cannot be empty.")
    @Max(value = 50, message = "The country name cannot exceed 50 characters in length.")
    private String name;
    
    private int area;
    
    private Date national_day;
    
    @NotBlank(message = "This value cannot be empty.")
    @Size(min = 2, max = 2, message = "The lenght of characters for this value must be 2.")
    private String country_code2;
    
    @NotBlank(message = "This value cannot be empty.")
    @Size(min = 3, max = 3, message = "The lenght of characters for this value must be 3.")
    private String country_code3;

    
}
