package com.myback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myback.dao.LanguagesDao;
import com.myback.repository.LanguageRepository;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public List<LanguagesDao> getAll(int cid) {
        return languageRepository.findAll(cid);
    }
}
