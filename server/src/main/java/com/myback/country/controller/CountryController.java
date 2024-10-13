package com.myback.country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.myback.country.dto.CountryDto;
import com.myback.country.dto.CreateCountryDto;
import com.myback.country.service.CountryService;
import com.myback.shared.config.HttpResponseBuilder;
import com.myback.shared.dto.HttpResponseDto;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private HttpResponseBuilder httpResponseBuilder;

    @GetMapping("/continents")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto<List<CountryDto>> getAllCountries(
            @RequestParam(value = "sort", defaultValue = "name", required = false) String sort,
            @RequestParam(value = "dir", defaultValue = "asc", required = false) String dir) {

        Sort sorting = dir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sort).ascending()
                : Sort.by(sort).descending();

        List<CountryDto> data = countryService.getAllCountries(sorting);
        return httpResponseBuilder.build(data);
    }

    @GetMapping("/continent/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto<CountryDto> getCountryById(@PathVariable int id) {
        return httpResponseBuilder.build(countryService.getCountryById(id));
    }

    // @PostMapping("/continent")
    // @ResponseStatus(HttpStatus.CREATED)
    // public HttpResponseDto<CountryDto> createNewCountry(@Valid @RequestBody CreateCountryDto newCountry) {
    //     // return httpResponseBuilder.build(countryService)
    // }
    

}