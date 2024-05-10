package com.myback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myback.dao.CountryDao;
import com.myback.dto.CountryDto;

import jakarta.persistence.Tuple;

public interface CountryRepository extends JpaRepository<CountryDao, Integer> {

    @Query("SELECT new com.myback.dto.CountryDto(c.country_id, c.name, c.area, c.country_code2) FROM CountryDao c")
    public List<CountryDto> getAllCountries();

    @Query(value = "SELECT c.name, c.country_code3, country_stats.year, country_stats.population, MAX(country_stats.gdp) as gdp FROM countries c LEFT JOIN country_stats ON country_stats.country_id = c.country_id GROUP BY c.name", nativeQuery=true)
    public List<Tuple> getCountriesAndTheirMaxGdp();


    // (SELECT c2.statistics.year FROM CountryDao c2 ORDER BY c2.statistics.gdp DESC LIMIT 1)
    // @Query("SELECT new com.myback.dto.CountryMaxGdpDto(c.name, c.country_code3) FROM CountryDao c")

    // SELECT name, country_code3, year, population, MAX(gdp) as gdp
    // FROM countries c
    // LEFT JOIN country_stats ON country_stats.country_id = c.country_id
    // GROUP BY name

}
