package com.myback.stats.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;

import com.myback.continent.dao.ContinentDao;
import com.myback.stats.dto.StatsPerCountryDto;

public interface StatsRepository extends JpaRepository<ContinentDao, Integer> {
    
    @Query("SELECT new com.myback.stats.dto.StatsPerCountryDto(c.name AS continent_name, r.name AS region_name, " +
    "co.name AS country_name, s.year AS year, s.population AS population, s.gdp as gdp) " +
    "FROM ContinentDao c " +
    "LEFT JOIN c.regions r " +
    "LEFT JOIN r.countries co " +
    "LEFT JOIN co.statistics s ")
    public Page<StatsPerCountryDto> fetchStatsPerCountry(Pageable pageable);

}
