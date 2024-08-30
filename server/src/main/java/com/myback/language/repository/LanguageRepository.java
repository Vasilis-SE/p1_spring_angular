package com.myback.language.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myback.language.dao.LanguagesDao;

public interface LanguageRepository extends JpaRepository<LanguagesDao, Integer> {
    
}
