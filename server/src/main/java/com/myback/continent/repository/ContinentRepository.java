package com.myback.continent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.myback.continent.dao.ContinentDao;

public interface ContinentRepository extends JpaRepository<ContinentDao, Integer> {
    public Optional<ContinentDao> findByName(String name);
}
