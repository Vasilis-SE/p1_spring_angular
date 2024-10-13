package com.myback.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myback.country.dao.CountryDao;

public interface CountryRepository extends JpaRepository<CountryDao, Integer> {
}
