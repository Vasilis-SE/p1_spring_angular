package com.myback.language.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myback.language.dao.LanguageDao;

public interface LanguageRepository extends JpaRepository<LanguageDao, Integer> {
    
}
