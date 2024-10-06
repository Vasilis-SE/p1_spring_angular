package com.myback.dummy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myback.continent.dao.ContinentDao;

public interface DummyRepository extends JpaRepository<ContinentDao, Integer> {

}
