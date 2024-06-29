package com.myback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myback.dao.LanguagesDao;

public interface LanguageRepository extends JpaRepository<LanguagesDao, Integer> {
    
}
