package com.myback.region.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myback.region.dto.RegionDto;
import com.myback.region.service.RegionService;
import com.myback.shared.config.HttpResponseBuilder;
import com.myback.shared.dto.HttpResponseDto;

@RestController
@RequestMapping("/api/v1")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @Autowired
    private HttpResponseBuilder httpResponseBuilder;

    @GetMapping("/regions")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto<List<RegionDto>> getRegionsList(
            @RequestParam(value = "sort", defaultValue = "name", required = false) String sort,
            @RequestParam(value = "dir", defaultValue = "asc", required = false) String dir) {

        Sort sorting = dir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sort).ascending()
                : Sort.by(sort).descending();

        List<RegionDto> data = regionService.getRegionsList(sorting);
        return httpResponseBuilder.build(data);
    }

}
