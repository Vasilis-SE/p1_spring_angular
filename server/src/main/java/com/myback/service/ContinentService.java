package com.myback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myback.dao.ContinentDao;
import com.myback.dto.ContinentDto;
import com.myback.dto.RegionToStatsDto;
import com.myback.repository.ContinentRepository;

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

    public List<ContinentDao> getContinentsTree() {
        return continentRepository.findAll();
    }

    public Optional<ContinentDao> getContinentTreeById(int id) {
        return continentRepository.findById(id);
    }

    public List<RegionToStatsDto> getContinentsTreeWithStatsMin() {
        return continentRepository.fetchRegionToStatsDataMinified();
    }

}
