package com.myback.dto;

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
    private Integer year;
    private Long population;
    private Long gdp;


    // public RegionToStatsDto(String cn, String rn, String con, int y, Integer p) {
    //     this.continent_name = cn;
    //     this.region_name = rn;
    //     this.country_name = con;
    //     this.year = y;
    //     this.population = (null == p) ? 0 : p;
    //     // this.gdp = g;
    // }

}
