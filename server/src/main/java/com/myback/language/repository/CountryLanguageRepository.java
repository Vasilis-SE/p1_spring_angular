package com.myback.language.repository;

import com.myback.language.dao.CountryLanguageDao;
import com.myback.language.dao.CountryLanguageId;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryLanguageRepository extends JpaRepository<CountryLanguageDao, CountryLanguageId> {

}

