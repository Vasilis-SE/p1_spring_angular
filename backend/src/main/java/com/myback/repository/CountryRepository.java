package com.myback.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.myback.dao.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    // public List<Country> getAllCountries();
}
