package com.myback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myback.dao.CountryDao;
import com.myback.dto.CountryDto;

public interface CountryRepository extends JpaRepository<CountryDao, Integer> {

    @Query("SELECT new com.myback.dto.CountryDto(c.name, c.area, c.country_code2) FROM CountryDao c")
    public List<CountryDto> getAllCountries();
}
