package com.myback.stats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.*;

import com.myback.stats.service.StatsService;
import com.myback.shared.config.HttpResponseBuilder;
import com.myback.shared.dto.HttpResponseDto;
import com.myback.shared.exceptions.InvalidArgumentException;
import com.myback.stats.dto.StatsPerCountryDto;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @Autowired
    private HttpResponseBuilder httpResponseBuilder;

    @GetMapping("/stats/percountry")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto<List<StatsPerCountryDto>> getStatsPerCountry(
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(name = "size", defaultValue = "10", required = false) Integer size,
            @RequestParam(value = "sort", defaultValue = "continent_name", required = false) String sort,
            @RequestParam(value = "dir", defaultValue = "asc", required = false) String dir)
            throws InvalidArgumentException {
        Sort sorting = dir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sort).ascending()
                : Sort.by(sort).descending();

        Pageable pagination = PageRequest.of(page, size, sorting);

        Page<StatsPerCountryDto> data = statsService.getStatsPerCountry(pagination);
        return httpResponseBuilder.build(data);
    }
}
