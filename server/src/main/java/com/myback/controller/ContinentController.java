package com.myback.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myback.dao.ContinentDao;
import com.myback.dto.ContinentDto;
import com.myback.dto.RegionToStatsDto;
import com.myback.service.ContinentService;

@RestController
@RequestMapping("/api/v1")
public class ContinentController {

    private static final Logger logger = LoggerFactory.getLogger(ContinentController.class);

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
    public List<ContinentDao> getContinentsTree() {
        return continentService.getContinentsTree();
    }

    @GetMapping("/continents/tree/{id}")
    public Optional<ContinentDao> getContinentTreeById(int id) {
        return continentService.getContinentTreeById(id);
    }






    @GetMapping("/continents/tree/min")
    public List<RegionToStatsDto> getContinentsTreeWithStatsMin() {
        return continentService.getContinentsTreeWithStatsMin();
    }

}
