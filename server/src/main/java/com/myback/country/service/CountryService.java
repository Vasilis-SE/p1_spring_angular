package com.myback.country.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myback.country.dao.CountryDao;
import com.myback.country.dto.CountryDto;
import com.myback.country.repository.CountryRepository;
import com.myback.stats.dto.CountryMaxGdpStatDto;

import jakarta.persistence.Tuple;

@Service
public class CountryService {
    
    @Autowired
    private CountryRepository countryRepository;

    public List<CountryDto> getAllCountries() {
        return countryRepository.getAllCountries();
    }

    public List<CountryDao> getAllCountriesWithStats() {
        return countryRepository.findAll();
    }

    public List<CountryMaxGdpStatDto> getAllCountriesAndTheirMaxGdp() {
        List<Tuple> maxGdpResults = countryRepository.getCountriesAndTheirMaxGdp();
        
        List<CountryMaxGdpStatDto> countryMaxGdpList = new ArrayList<CountryMaxGdpStatDto>();
        for (Tuple row : maxGdpResults){
            countryMaxGdpList.add(CountryMaxGdpStatDto.builder()
                .name((String) row.get(0))
                .country_code3((String) row.get(1))
                .year((int) (row.get(2) != null ? row.get(2) : 0))
                .population((int) (row.get(3) != null ? row.get(3) : 0))
                .gdp((BigDecimal) (row.get(4) != null ? row.get(4) : new BigDecimal(0)))
                .build());
        }

        return countryMaxGdpList;
    }
    
}
