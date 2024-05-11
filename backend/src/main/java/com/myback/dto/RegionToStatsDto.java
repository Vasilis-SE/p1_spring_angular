package com.myback.dto;

import java.math.BigDecimal;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegionToStatsDto {
    private String continent_name;
    private String region_name;
    private String country_name;
    private int year;
    private int population;
    private BigDecimal gdp;

    // public RegionToStatsDto(String continent_name, String region_name, String country_name, int year, int population,
    //         BigDecimal gdp) {
    //     this.continent_name = continent_name;
    //     this.region_name = region_name;
    //     this.country_name = country_name;
    //     this.year = year;
    //     this.population = population;
    //     this.gdp = gdp;
    // }
}
