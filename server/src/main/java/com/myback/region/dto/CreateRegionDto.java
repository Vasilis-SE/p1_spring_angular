package com.myback.region.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRegionDto {

    @NotNull(message = "This value cannot be null")
    @Min(value = 1, message = "This field must contain a positive continent id")
    private Integer continent_id;

    @NotBlank(message = "Region name cannot be empty")
    @Size(min = 3, max = 100, message = "The size of the region name should be between 3 and 100 characters long")
    private String name;

}
