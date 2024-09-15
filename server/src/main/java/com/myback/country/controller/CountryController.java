package com.myback.country.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myback.country.service.CountryService;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    
    @Autowired
    private CountryService countryService;

    // @GetMapping
    // public List<CountryDto> getAllCountries() {
    //     return countryService.getAllCountries();
    // }

    // @GetMapping("/stats")
    // public List<CountryDao> getAllCountriesWithStats() {
    //     return countryService.getAllCountriesWithStats();
    // }

    // @GetMapping("/stats/mgdp")
    // public List<CountryMaxGdpDto> getAllCountriesAndTheirMaxGdp() {
    //     return countryService.getAllCountriesAndTheirMaxGdp();
    // }

}