package com.myback.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import com.myback.dao.ContinentDao;
import com.myback.dto.ContinentDto;
import com.myback.dto.HttpResponseDto;
import com.myback.dto.RegionToStatsDto;
import com.myback.exception.InvalidArgumentException;
import com.myback.service.ContinentService;

@RestController
@RequestMapping("/api/v1")
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @GetMapping("/continents")
    public HttpResponseDto<List<ContinentDto>> getContinentsList(
        @RequestParam(value = "sort", defaultValue = "name", required = false) String sort,
        @RequestParam(value = "dir", defaultValue = "asc", required = false) String dir
    ) {        
        Sort sorting = dir.equalsIgnoreCase(Sort.Direction.ASC.name())
            ? Sort.by(sort).ascending()
            : Sort.by(sort).descending();

        Pageable pagination = PageRequest.of(0, Integer.MAX_VALUE, sorting);
        

        return continentService.getContinentsList(pagination);
    }

    @GetMapping("/continent/{id}")
    public ContinentDto getContinentById(@PathVariable int id) {
        return continentService.getContinentById(id);
    }







    
    @GetMapping("/continents/tree")
    public HttpResponseDto<List<ContinentDao>> getContinentsTree(
        @RequestParam(name = "page", defaultValue = "0", required = false) Integer page, 
        @RequestParam(name = "size", defaultValue = "2", required = false) Integer size,
        @RequestParam(value = "sort", defaultValue = "name", required = false) String sort,
        @RequestParam(value = "dir", defaultValue = "asc", required = false) String dir
    ) throws InvalidArgumentException {        
        Sort sorting = dir.equalsIgnoreCase(Sort.Direction.ASC.name())
            ? Sort.by(sort).ascending()
            : Sort.by(sort).descending();

        Pageable pagination = PageRequest.of(page, size, sorting);
        
        return continentService.getContinentsTree(pagination);
    }

    @GetMapping("/continents/tree/{id}")
    public Optional<ContinentDao> getContinentTreeById(int id) {
        return continentService.getContinentTreeById(id);
    }

    @GetMapping("/continents/tree/min")
    public HttpResponseDto<List<RegionToStatsDto>> getContinentsTreeWithStatsMin(
        @RequestParam(name = "page", defaultValue = "0", required = false) Integer page, 
        @RequestParam(name = "size", defaultValue = "10", required = false) Integer size,
        @RequestParam(value = "sort", defaultValue = "continent_name", required = false) String sort,
        @RequestParam(value = "dir", defaultValue = "asc", required = false) String dir
    ) throws InvalidArgumentException {
        Sort sorting = dir.equalsIgnoreCase(Sort.Direction.ASC.name())
            ? Sort.by(sort).ascending()
            : Sort.by(sort).descending();

        Pageable pagination = PageRequest.of(page, size, sorting);

        return continentService.getContinentsTreeWithStatsMin(pagination);
    }

}
