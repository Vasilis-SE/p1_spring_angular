package com.myback.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import com.myback.dao.ContinentDao;
import com.myback.dto.ContinentDto;
import com.myback.dto.RegionToStatsDto;

public interface ContinentRepository extends ListCrudRepository<ContinentDao, Integer> {

    @Query("SELECT new com.myback.dto.RegionToStatsDto(c.name AS continent_name, r.name AS region_name, " +
            "co.name AS country_name, s.year AS year, s.population AS population, s.gdp as gdp) " +
            "FROM ContinentDao c " +
            "LEFT JOIN c.regions r " +
            "LEFT JOIN r.countries co " +
            "LEFT JOIN co.statistics s ")
    public List<RegionToStatsDto> fetchRegionToStatsDataMinified(Pageable pageable);

    // Fetch continents without regions
    @Query("SELECT new com.myback.dto.ContinentDto(c.continent_id, c.name) FROM ContinentDao c")
    public List<ContinentDto> fetchContinentsList();

    // Fetch continent without regions by id
    @Query("SELECT new com.myback.dto.ContinentDto(c.continent_id, c.name) FROM ContinentDao c WHERE c.continent_id = ?1")
    public ContinentDto fetchContinentById(int id);

}
