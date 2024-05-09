package com.myback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myback.dao.LanguagesDao;
import com.myback.service.LanguageService;


@RestController
@RequestMapping("/api/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping("/bycountry/{cid}")
    public List<LanguagesDao> getLanguagesByCountryId(@PathVariable int cid) {
        return languageService.getAll(cid);
    }

}
