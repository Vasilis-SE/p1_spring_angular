package com.myback.country.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    private int countryId;
    private String name;
    private int area;

    @JsonFormat(pattern = "yyyy-MM-dd")    
    private Date nationalDay;
    private String countryCode2;
    private String countryCode3;
}