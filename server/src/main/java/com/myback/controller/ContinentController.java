package com.myback.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myback.dao.ContinentDao;
import com.myback.dto.ContinentDto;
import com.myback.dto.RegionToStatsDto;
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
    public List<ContinentDao> getContinentWithRegionsTree() {
        return continentService.getContinentWithRegionsTree();
    }

    @GetMapping("/continents/tree/{id}")
    public Optional<ContinentDao> getContinentWithRegionsTreeById(int id) {
        return continentService.getContinentWithRegionsTreeById(id);
    }






    @GetMapping("/continents/tree/min")
    public List<RegionToStatsDto> getRegionToStatsDataMinified() {
        return continentService.getRegionToStatsDataMinified();
    }

}
