package com.myback.repository;

import com.myback.dao.CountryLanguageDao;
import com.myback.dao.CountryLanguageId;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryLanguageRepository extends JpaRepository<CountryLanguageDao, CountryLanguageId> {

}

