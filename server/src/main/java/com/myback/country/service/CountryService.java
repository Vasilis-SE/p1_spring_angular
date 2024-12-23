package com.myback.country.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.myback.country.dao.CountryDao;
import com.myback.country.dto.CountryDto;
import com.myback.country.dto.CreateCountryDto;
import com.myback.country.repository.CountryRepository;
import com.myback.region.dao.RegionDao;
import com.myback.region.repository.RegionRepository;
import com.myback.shared.exceptions.DataExistsException;
import com.myback.shared.exceptions.DataNotFoundException;

import jakarta.persistence.Converter;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<CountryDto> getCountriesList(Pageable page) {
        Page<CountryDao> data = countryRepository.findAll(page);
        if (!data.hasContent())
            throw new DataNotFoundException(null);



        // return data.stream()
        //         .map(country -> modelMapper.map(country, CountryDto.class))
        //         .collect(Collectors.toList());
    }

    public CountryDto getCountryById(Integer id) {
        Optional<CountryDao> data = countryRepository.findById(id);
        if (!data.isPresent())
            throw new DataNotFoundException(null);

        return modelMapper.map(data.get(), CountryDto.class);
    }

    public CountryDto createNewCountry(CreateCountryDto createCountryDto) {
        Optional<RegionDao> region = regionRepository.findById(createCountryDto.getRegionId());
        if (!region.isPresent())
            throw new DataNotFoundException(null);

        if (countryRepository.findByName(createCountryDto.getName()).isPresent())
            throw new DataExistsException(null);

        CountryDao newCountry = modelMapper.map(createCountryDto, CountryDao.class);
        newCountry.setRegion(region.get());

        return modelMapper.map(countryRepository.save(newCountry), CountryDto.class);
    }

    public CountryDto deleteCountry(int id) {
        Optional<CountryDao> storedCountry = countryRepository.findById(id);
        if (!storedCountry.isPresent())
            throw new DataNotFoundException(null);

        countryRepository.deleteById(storedCountry.get().getCountryId());
        return modelMapper.map(storedCountry.get(), CountryDto.class);
    }
}
