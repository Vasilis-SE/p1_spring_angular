package com.myback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.myback.config.HttpResponseBuilder;
import com.myback.dao.ContinentDao;
import com.myback.dto.ContinentDto;
import com.myback.dto.HttpResponseDto;
import com.myback.dto.RegionToStatsDto;
import com.myback.exception.InvalidArgumentException;
import com.myback.service.ContinentService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
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
    public HttpResponseDto<ContinentDto> createNewContinent(@RequestBody @Valid ContinentDto newContinent, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors();
            return ResponseEntity.badRequest().body("Validation failed");
        }

        ContinentDto data = continentService.createNewContinent(newContinent);
        return httpResponseBuilder.build(data);
    }

















    @GetMapping("/continents/tree")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto<List<ContinentDao>> getContinentsTree(
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(name = "size", defaultValue = "2", required = false) Integer size,
            @RequestParam(value = "sort", defaultValue = "name", required = false) String sort,
            @RequestParam(value = "dir", defaultValue = "asc", required = false) String dir)
            throws InvalidArgumentException {
        Sort sorting = dir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sort).ascending()
                : Sort.by(sort).descending();

        Pageable pagination = PageRequest.of(page, size, sorting);

        Page<ContinentDao> data = continentService.getContinentsTree(pagination);
        return httpResponseBuilder.build(data);
    }

    @GetMapping("/continents/tree/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto<ContinentDao> getContinentTreeById(int id) {
        ContinentDao data = continentService.getContinentTreeById(id);
        return httpResponseBuilder.build(data);
    }

    @GetMapping("/continents/tree/min")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto<List<RegionToStatsDto>> getContinentsTreeWithStatsMin(
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(name = "size", defaultValue = "10", required = false) Integer size,
            @RequestParam(value = "sort", defaultValue = "continent_name", required = false) String sort,
            @RequestParam(value = "dir", defaultValue = "asc", required = false) String dir)
            throws InvalidArgumentException {
        Sort sorting = dir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sort).ascending()
                : Sort.by(sort).descending();

        Pageable pagination = PageRequest.of(page, size, sorting);

        Page<RegionToStatsDto> data = continentService.getContinentsTreeWithStatsMin(pagination);
        return httpResponseBuilder.build(data);
    }

}
