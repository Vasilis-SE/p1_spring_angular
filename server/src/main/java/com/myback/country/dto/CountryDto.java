package com.myback.country.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    private int country_id;
    private String name;
    private int area;
    private String country_code2;
}
