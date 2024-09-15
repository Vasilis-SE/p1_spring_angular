package com.myback.country.dto;

import lombok.*;

@Getter
@Setter
public class CountryDto {     

    private int country_id;
    private String name;
    private int area;
    private String country_code2;

    public CountryDto(int country_id, String name, int area, String country_code2) {
        this.country_id = country_id;
        this.name = name;
        this.area = area;
        this.country_code2 = country_code2;
    }

}
