package com.myback.dummy.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myback.continent.dao.ContinentDao;

public interface DummyRepository extends JpaRepository<ContinentDao, Integer> {

    // @Query("SELECT new com.myback.continent.dao.ContinentDao(c.continent_id, c.name, c.regions) FROM ContinentDao c")
    // public Page<ContinentDao> fetchAll(Pageable pagination);

    
}
