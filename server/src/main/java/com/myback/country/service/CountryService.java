package com.myback.country.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myback.country.dao.CountryDao;
import com.myback.country.dto.CountryDto;
import com.myback.country.dto.CreateCountryDto;
import com.myback.country.repository.CountryRepository;
import com.myback.shared.exceptions.DataNotFoundException;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CountryDto> getAllCountries(Sort sorting) {
        List<CountryDao> data = countryRepository.findAll(sorting);
        if (data.isEmpty())
            throw new DataNotFoundException(null);

        return data.stream()
                .map(country -> modelMapper.map(country, CountryDto.class))
                .collect(Collectors.toList());
    }

    public CountryDto getCountryById(Integer id) {
        Optional<CountryDao> data = countryRepository.findById(id);
        if (!data.isPresent())
            throw new DataNotFoundException(null);

        return modelMapper.map(data.get(), CountryDto.class);
    }

    // public CountryDto createNewCountry(CreateCountryDto newCountry) {
    //     CountryDao countryDao = modelMapper.map(newCountry, CountryDao.class);

    //     if(countryDao)

    //     // TODO: check if region with the id provided exists
    //     // TODO: check if country exists with the given name.
    //     // TODO: save new country
    // }

}
