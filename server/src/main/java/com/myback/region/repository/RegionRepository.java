package com.myback.region.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
import com.myback.region.dao.RegionDao;

public interface RegionRepository extends JpaRepository<RegionDao, Integer> {

    @Query("SELECT new com.myback.region.dao.RegionDao(r.region_id, r.name) FROM RegionDao r WHERE r.name = ?1")
    public Optional<RegionDao> findByName(String name);

}
