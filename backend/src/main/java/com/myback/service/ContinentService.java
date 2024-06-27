package com.myback.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myback.dao.ContinentDao;
import com.myback.dto.ContinentDto;
import com.myback.dto.RegionToStatsDto;
import com.myback.repository.ContinentRepository;

import jakarta.persistence.Tuple;

@Service
public class ContinentService {
    
    @Autowired
    private ContinentRepository continentRepository;


    public List<ContinentDto> getContinentsList() {
        return continentRepository.fetchContinentsList();
    }

    public ContinentDto getContinentById(int id) {
        return continentRepository.fetchContinentById(id);
    }

    public List<ContinentDao> getContinentWithRegionsTree() {
        return continentRepository.findAll();
    }

    public Optional<ContinentDao> getContinentWithRegionsTreeById(int id) {
        return continentRepository.findById(id);
    }

    public List<RegionToStatsDto> getRegionToStatsDataMinified() {
        return continentRepository.fetchRegionToStatsDataMinified();
    }

}
