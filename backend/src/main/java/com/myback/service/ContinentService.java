package com.myback.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myback.dao.ContinentDao;
import com.myback.dto.RegionToStatsDto;
import com.myback.repository.ContinentRepository;

import jakarta.persistence.Tuple;

@Service
public class ContinentService {
    
    @Autowired
    private ContinentRepository continentRepository;

    public List<ContinentDao> getContinentRegionCountryAndStatsTree() {
        return continentRepository.findAll();
    }

    public List<RegionToStatsDto> getRegionToStatsDataMinified() {
        List<Tuple> regionToStatsResults = continentRepository.fetchRegionToStatsDataMinified();

        List<RegionToStatsDto> regionToStatsList = new ArrayList<RegionToStatsDto>();
        for (Tuple row : regionToStatsResults){
            regionToStatsList.add(RegionToStatsDto.builder()
                .continent_name((String) row.get(0))
                .region_name((String) row.get(1))
                .country_name((String) row.get(2))
                .year((int) (row.get(3) != null ? row.get(3) : 0))
                .population((int) (row.get(4) != null ? row.get(4) : 0))
                .gdp((BigDecimal) (row.get(5) != null ? row.get(5) : new BigDecimal(0)))
                .build());
        }

        return regionToStatsList;
    }

}
