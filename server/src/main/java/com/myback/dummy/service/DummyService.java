package com.myback.dummy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.myback.continent.dao.ContinentDao;
import com.myback.dummy.repository.DummyRepository;
import com.myback.shared.exceptions.DataNotFoundException;

@Service
public class DummyService {

    @Autowired
    private DummyRepository dummyRepository;


    public Page<ContinentDao> getContinentsTree(Pageable pagination) {
        Page<ContinentDao> data = dummyRepository.findAll(pagination);
        if (!data.hasContent())
            throw new DataNotFoundException(null);
        return data;
    }

    public ContinentDao getContinentTreeById(int id) {
        return dummyRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(null));
    }

}
