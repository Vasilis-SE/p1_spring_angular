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
    public List<ContinentDto> getContinentsList() {
        return continentService.getContinentsList();
    }

    @GetMapping("/continent/{id}")
    public ContinentDto getContinentById(@PathVariable int id) {
        return continentService.getContinentById(id);
    }

    @GetMapping("/continents/tree")
    public HttpResponseDto<List<ContinentDao>> getContinentsTree(
        @RequestParam(name = "page", defaultValue = "0", required = false) Integer page, 
        @RequestParam(name = "size", defaultValue = "2", required = false) Integer size,
        @RequestParam(value = "sortBy", defaultValue = "name", required = false) String sortBy,
        @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) throws InvalidArgumentException {

        if(page < 0) throw new InvalidArgumentException(null, "page", page.toString(), ">=0");
        if(size <= 0) throw new InvalidArgumentException(null, "size", size.toString(), ">0");
        
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
            ? Sort.by(sortBy).ascending()
            : Sort.by(sortBy).descending();

        Pageable pagination = PageRequest.of(page, size, sort);
        
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
        @RequestParam(value = "sortBy", defaultValue = "continent_name", required = false) String sortBy,
        @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) throws InvalidArgumentException {

        if(page < 0) throw new InvalidArgumentException(null, "page", page.toString(), ">=0");
        if(size <= 0) throw new InvalidArgumentException(null, "size", size.toString(), ">0");

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
            ? Sort.by(sortBy).ascending()
            : Sort.by(sortBy).descending();

        Pageable pagination = PageRequest.of(page, size, sort);

        return continentService.getContinentsTreeWithStatsMin(pagination);
    }

}
