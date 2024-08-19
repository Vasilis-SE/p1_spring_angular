package com.myback.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import java.util.List;

import com.myback.dao.ContinentDao;
import com.myback.dto.ContinentDto;
import com.myback.dto.RegionToStatsDto;

public interface ContinentRepository extends JpaRepository<ContinentDao, Integer> {

    @Query("SELECT new com.myback.dto.RegionToStatsDto(c.name AS continent_name, r.name AS region_name, " +
            "co.name AS country_name, s.year AS year, s.population AS population, s.gdp as gdp) " +
            "FROM ContinentDao c " +
            "LEFT JOIN c.regions r " +
            "LEFT JOIN r.countries co " +
            "LEFT JOIN co.statistics s ")
    public Page<RegionToStatsDto> fetchRegionToStatsDataMinified(Pageable pageable);

    // Fetch all continents from database
    @Query("SELECT new com.myback.dto.ContinentDto(c.continent_id, c.name) FROM ContinentDao c")
    public List<ContinentDto> fetchAllContinents(Sort sorting);

    // Fetch continent without regions by id
    @Query("SELECT new com.myback.dto.ContinentDto(c.continent_id, c.name) FROM ContinentDao c WHERE c.continent_id = ?1")
    public ContinentDto fetchContinentById(int id);


}
