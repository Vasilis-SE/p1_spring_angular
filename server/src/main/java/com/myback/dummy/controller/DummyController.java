package com.myback.dummy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myback.continent.dao.ContinentDao;
import com.myback.dummy.service.DummyService;
import com.myback.shared.config.HttpResponseBuilder;
import com.myback.shared.dto.HttpResponseDto;
import com.myback.shared.exceptions.InvalidArgumentException;

@RestController
@RequestMapping("/api/v1/dummy")
@Profile("development")
public class DummyController {

    @Autowired
    private HttpResponseBuilder httpResponseBuilder;

    @Autowired
    private DummyService dummyService;

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

        Page<ContinentDao> data = dummyService.getContinentsTree(pagination);
        return httpResponseBuilder.build(data);
    }

    @GetMapping("/continents/tree/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpResponseDto<ContinentDao> getContinentTreeById(int id) {
        ContinentDao data = dummyService.getContinentTreeById(id);
        return httpResponseBuilder.build(data);
    }

}
