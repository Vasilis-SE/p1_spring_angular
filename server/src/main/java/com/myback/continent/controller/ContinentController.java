package com.myback.continent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.myback.continent.dto.ContinentDto;
import com.myback.continent.dto.CreateContinentDto;
import com.myback.continent.service.ContinentService;
import com.myback.shared.config.HttpResponseBuilder;
import com.myback.shared.dto.HttpResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @Autowired
    private HttpResponseBuilder httpResponseBuilder;

    @GetMapping("/continents")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto<List<ContinentDto>> getContinentsList(
            @RequestParam(value = "sort", defaultValue = "name", required = false) String sort,
            @RequestParam(value = "dir", defaultValue = "asc", required = false) String dir) {
        Sort sorting = dir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sort).ascending()
                : Sort.by(sort).descending();

        List<ContinentDto> data = continentService.getContinentsList(sorting);
        return httpResponseBuilder.build(data);
    }

    @GetMapping("/continent/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto<ContinentDto> getContinentById(@PathVariable int id) {
        ContinentDto data = continentService.getContinentById(id);
        return httpResponseBuilder.build(data);
    }

    @PostMapping("/continent")
    @ResponseStatus(HttpStatus.CREATED)
    public HttpResponseDto<ContinentDto> createNewContinent(@Valid @RequestBody CreateContinentDto newContinent) {
        ContinentDto data = continentService.createNewContinent(newContinent);
        return httpResponseBuilder.build(data);
    }

}
