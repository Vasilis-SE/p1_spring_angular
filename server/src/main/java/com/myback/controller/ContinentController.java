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
    public List<ContinentDao> getContinentsTree() {
        return continentService.getContinentsTree();
    }

    @GetMapping("/continents/tree/{id}")
    public Optional<ContinentDao> getContinentTreeById(int id) {
        return continentService.getContinentTreeById(id);
    }

    @GetMapping("/continents/tree/min")
    public List<RegionToStatsDto> getContinentsTreeWithStatsMin(@RequestParam("page") Integer p, @RequestParam("size") Optional<Integer> s) throws InvalidArgumentException {
        Integer page = p;
        Integer size = (!s.isPresent()) ? 10 : s.get();

        if(page < 0) throw new InvalidArgumentException(null, "page", page.toString(), ">=0");
        if(size <= 0) throw new InvalidArgumentException(null, "size", size.toString(), ">0");

        return continentService.getContinentsTreeWithStatsMin(page, size);
    }

}
