package com.myback.dto;

import java.math.BigDecimal;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryMaxGdpDto {
    private String name;
    private String country_code3;
    private int year;
    private int population;
    private BigDecimal gdp;
}
