package com.myback.dto;

import lombok.*;

@Getter
@Setter
public class CountryDto {     

    private String name;
    private int area;
    private String country_code2;

    public CountryDto(String name, int area, String country_code2) {
        this.name = name;
        this.area = area;
        this.country_code2 = country_code2;
    }

}
