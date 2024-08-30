package com.myback.language.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myback.language.dao.CountryLanguageDao;
import com.myback.language.dto.LanguageForCountryDto;
import com.myback.language.dto.LanguagesPerCountryDto;
import com.myback.language.repository.CountryLanguageRepository;

@Service
public class LanguageService {

    @Autowired
    private CountryLanguageRepository countryLanguageRepository;

    // public List<CountryLanguageDao> getAllCountryToLanguageCorrelations() {
    //     return countryLanguageRepository.findAll();
    // }

    // public LanguagesPerCountryDto getLanguagesByCountryId(int cid) {
    //     List<CountryLanguageDao> countryToLangList = countryLanguageRepository.fetchLanguagesByCountryId(cid);

    //     List<LanguageForCountryDto> listOfLanguages = new ArrayList<LanguageForCountryDto>();
    //     for (CountryLanguageDao cl : countryToLangList) {
    //         listOfLanguages.add(new LanguageForCountryDto(
    //             cl.getLanguage().getLanguage_id(), 
    //             cl.getLanguage().getLanguage(), 
    //             cl.getOfficial()));
    //     }  

    //     return LanguagesPerCountryDto.builder()
    //         .name(countryToLangList.get(0).getCountry().getName())
    //         .languages(listOfLanguages)
    //         .build();
    // }
    
}
