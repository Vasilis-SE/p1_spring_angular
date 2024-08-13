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
}
