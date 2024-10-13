package com.myback.region.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myback.region.dao.RegionDao;

public interface RegionRepository extends JpaRepository<RegionDao, Integer> {

}
