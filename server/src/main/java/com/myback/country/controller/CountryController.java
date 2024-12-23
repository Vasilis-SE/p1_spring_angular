package com.myback.country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/api/v1")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private HttpResponseBuilder httpResponseBuilder;

    @GetMapping("/countries")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto<List<CountryDto>> getCountriesList(
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(name = "size", defaultValue = "10", required = false) Integer size,
            @RequestParam(value = "sort", defaultValue = "name", required = false) String sort,
            @RequestParam(value = "dir", defaultValue = "asc", required = false) String dir) {

        Sort sorting = dir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sort).ascending()
                : Sort.by(sort).descending();

        Pageable pagination = PageRequest.of(page, size, sorting);
        List<CountryDto> data = countryService.getCountriesList(pagination);
        return httpResponseBuilder.build(data);
    }

    @GetMapping("/country/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto<CountryDto> getCountryById(@PathVariable int id) {
        return httpResponseBuilder.build(countryService.getCountryById(id));
    }

    @PostMapping("/country")
    @ResponseStatus(HttpStatus.CREATED)
    public HttpResponseDto<CountryDto> createNewCountry(@Valid @RequestBody CreateCountryDto newCountry) {
        return httpResponseBuilder.build(countryService.createNewCountry(newCountry));
    }

    @DeleteMapping("/country/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto<CountryDto> deleteCountry(@PathVariable int id) {
        return httpResponseBuilder.build(countryService.deleteCountry(id));
    }

}