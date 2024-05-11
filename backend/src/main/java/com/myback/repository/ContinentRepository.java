package com.myback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myback.dao.ContinentDao;

import jakarta.persistence.Tuple;

public interface ContinentRepository extends JpaRepository<ContinentDao, Integer> {

    @Query(value = "SELECT continents.name as cname, regions.name as rname, countries.name as coname, " +
            "country_stats.`year`, country_stats.population, country_stats.gdp " +
            "FROM continents " +
            "LEFT JOIN regions ON regions.continent_id = continents.continent_id " +
            "LEFT JOIN countries ON countries.region_id = regions.region_id " +
            "LEFT JOIN country_stats ON country_stats.country_id = countries.country_id", nativeQuery = true)
    public List<Tuple> fetchRegionToStatsDataMinified();

}
