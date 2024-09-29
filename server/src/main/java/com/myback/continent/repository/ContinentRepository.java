package com.myback.continent.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

import com.myback.continent.dao.ContinentDao;
import com.myback.continent.dto.ContinentDto;

public interface ContinentRepository extends JpaRepository<ContinentDao, Integer> {

    // Fetch all continents from database
    @Query("SELECT new com.myback.continent.dto.ContinentDto(c.continent_id, c.name) FROM ContinentDao c")
    public List<ContinentDto> fetchAllContinents(Sort sorting);

    // Fetch continent without regions by id
    @Query("SELECT new com.myback.continent.dto.ContinentDto(c.continent_id, c.name) FROM ContinentDao c WHERE c.continent_id = ?1")
    public ContinentDto fetchContinentById(int id);

    // Fetch continent without regions by continent name
    @Query("SELECT new com.myback.continent.dto.ContinentDto(c.continent_id, c.name) FROM ContinentDao c WHERE c.name = ?1")
    public Optional<ContinentDto> fetchContinentByName(String name);
}
