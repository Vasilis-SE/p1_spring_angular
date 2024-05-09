package com.myback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myback.dao.Country;
import com.myback.repository.CountryRepository;

@Service
public class CountryService {
    
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
    
}
