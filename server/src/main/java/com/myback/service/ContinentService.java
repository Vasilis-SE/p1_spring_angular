package com.myback.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myback.dao.ContinentDao;
import com.myback.dto.ContinentDto;
import com.myback.dto.RegionToStatsDto;
import com.myback.repository.ContinentRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    public List<ContinentDao> getContinentsTree(Pageable pagination) {
        Page<ContinentDao> cTreeList = continentRepository.findAll(pagination);
        
        List<ContinentDao> content = cTreeList.getContent();

        ModelMapper modelMapper = new ModelMapper();
        List<ContinentDao> listOfCTree = content.stream()
            .map(continent -> modelMapper.map(continent, ContinentDao.class))
            .collect(Collectors.toList());
        
        return listOfCTree;
    }

    public Optional<ContinentDao> getContinentTreeById(int id) {
        return continentRepository.findById(id);
    }

    public List<RegionToStatsDto> getContinentsTreeWithStatsMin(Pageable pagination) {
        return continentRepository.fetchRegionToStatsDataMinified(pagination);
    }

}
