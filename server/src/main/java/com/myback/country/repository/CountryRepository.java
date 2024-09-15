package com.myback.country.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myback.country.dao.CountryDao;
import com.myback.country.dto.CountryDto;

import jakarta.persistence.Tuple;

public interface CountryRepository extends JpaRepository<CountryDao, Integer> {

    @Query("SELECT new com.myback.dto.CountryDto(c.country_id, c.name, c.area, c.country_code2) FROM CountryDao c")
    public List<CountryDto> getAllCountries();

    @Query(value = "SELECT c.name, c.country_code3, country_stats.year, country_stats.population, MAX(country_stats.gdp) as gdp FROM countries c LEFT JOIN country_stats ON country_stats.country_id = c.country_id GROUP BY c.name", nativeQuery=true)
    public List<Tuple> getCountriesAndTheirMaxGdp();

}
