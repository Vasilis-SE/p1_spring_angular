package com.myback.repository;

import com.myback.dao.CountryLanguageDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguageDao, Integer> {

    @Query("SELECT new com.myback.dao.CountryLanguageDao(cl.country, cl.language, cl.official) FROM CountryLanguageDao cl WHERE cl.country.country_id = ?1")
    public List<CountryLanguageDao> fetchLanguagesByCountryId(int cid);

}

