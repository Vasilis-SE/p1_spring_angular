package com.myback.dummy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.myback.continent.dao.ContinentDao;
import com.myback.continent.repository.ContinentRepository;
import com.myback.shared.exceptions.DataNotFoundException;

@Service
public class DummyService {

    @Autowired
    private ContinentRepository continentRepository;

    public Page<ContinentDao> getContinentsTree(Pageable pagination) {
        Page<ContinentDao> data = continentRepository.findAll(pagination);
        if (!data.hasContent())
            throw new DataNotFoundException(null);
        return data;
    }

    public ContinentDao getContinentTreeById(int id) {
        return continentRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(null));
    }

}
