package com.myback.continent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

import com.myback.continent.dao.ContinentDao;

public interface ContinentRepository extends JpaRepository<ContinentDao, Integer> {

    // Fetch continent without regions by continent name
    @Query("SELECT new com.myback.continent.dao.ContinentDao(c.continent_id, c.name) FROM ContinentDao c WHERE c.name = ?1")
    public Optional<ContinentDao> fetchContinentByName(String name);
}
