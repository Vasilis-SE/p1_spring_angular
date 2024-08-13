package com.myback.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myback.dao.ContinentDao;
import com.myback.dto.ContinentDto;
import com.myback.dto.HttpResponseDto;
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

    public HttpResponseDto<List<ContinentDao>> getContinentsTree(Pageable pagination) {
        Page<ContinentDao> dataList = continentRepository.findAll(pagination);
        List<ContinentDao> content = dataList.getContent();
        
        ModelMapper modelMapper = new ModelMapper();
        List<ContinentDao> listOfCTree = content.stream()
            .map(data -> modelMapper.map(data, ContinentDao.class))
            .collect(Collectors.toList());

        HttpResponseDto<List<ContinentDao>> httpResponse = new HttpResponseDto<List<ContinentDao>>();
        httpResponse.setData(listOfCTree);
        httpResponse.setPageNo(dataList.getNumber());
        httpResponse.setPageSize(dataList.getSize());
        httpResponse.setTotalElements(dataList.getTotalElements());
        httpResponse.setTotalPages(dataList.getTotalPages());
        httpResponse.setLastPage(dataList.isLast());

        return httpResponse;
    }

    public Optional<ContinentDao> getContinentTreeById(int id) {
        return continentRepository.findById(id);
    }

    public HttpResponseDto<List<RegionToStatsDto>> getContinentsTreeWithStatsMin(Pageable pagination) {
        Page<RegionToStatsDto> dataList = continentRepository.fetchRegionToStatsDataMinified(pagination);
        List<RegionToStatsDto> listOfMinRegions = dataList.getContent();

        ModelMapper modelMapper = new ModelMapper();
        List<RegionToStatsDto> content = listOfMinRegions.stream()
            .map(data -> modelMapper.map(data, RegionToStatsDto.class))
            .collect(Collectors.toList());

        HttpResponseDto<List<RegionToStatsDto>> httpResponse = new HttpResponseDto<List<RegionToStatsDto>>();
        httpResponse.setData(content);
        httpResponse.setPageNo(dataList.getNumber());
        httpResponse.setPageSize(dataList.getSize());
        httpResponse.setTotalElements(dataList.getTotalElements());
        httpResponse.setTotalPages(dataList.getTotalPages());
        httpResponse.setLastPage(dataList.isLast());

        return httpResponse;
    }

}
