package com.myback.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myback.dto.CountryDto;
import com.myback.service.CountryService;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    
    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<CountryDto> getAllCountries() {
        return countryService.getAllCountries();
    }
    
}