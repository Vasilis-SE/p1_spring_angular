package com.myback.language.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myback.language.dao.CountryLanguageDao;
import com.myback.language.dto.LanguagesPerCountryDto;
import com.myback.language.service.LanguageService;


@RestController
@RequestMapping("/api/language")
public class LanguageController {

    // @Autowired
    // private LanguageService languageService;

    // @GetMapping()
    // public List<CountryLanguageDao> getAllCountryToLanguageCorrelations() {
    //     return languageService.getAllCountryToLanguageCorrelations();
    // }

    // @GetMapping("/{cid}")
    // public LanguagesPerCountryDto getLanguagesByCountryId(@PathVariable int cid) {
    //     return languageService.getLanguagesByCountryId(cid);
    // }

}
