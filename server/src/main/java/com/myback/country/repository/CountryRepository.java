package com.myback.country.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myback.country.dao.CountryDao;

public interface CountryRepository extends JpaRepository<CountryDao, Integer> {
    public Optional<CountryDao> findByName(String name);
}
