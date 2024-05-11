package com.myback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myback.dao.ContinentDao;
import com.myback.dto.RegionToStatsDto;
import com.myback.service.ContinentService;

@RestController
@RequestMapping("/api/continent")
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @GetMapping("/tree")
    public List<ContinentDao> getContinentRegionCountryAndStatsTree() {
        return continentService.getContinentRegionCountryAndStatsTree();
    }

    @GetMapping("/min")
    public List<RegionToStatsDto> getRegionToStatsDataMinified() {
        return continentService.getRegionToStatsDataMinified();
    }

}
