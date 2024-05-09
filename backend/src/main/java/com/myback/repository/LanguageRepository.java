package com.myback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myback.dao.LanguagesDao;

public interface LanguageRepository extends JpaRepository<LanguagesDao, Integer> {
    public List<LanguagesDao> findAll(int country_id);
}
