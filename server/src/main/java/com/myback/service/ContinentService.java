package com.myback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.myback.dao.ContinentDao;
import com.myback.dto.ContinentDto;
import com.myback.dto.RegionToStatsDto;
import com.myback.exception.DataNotFoundException;
import com.myback.repository.ContinentRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class ContinentService {

    @Autowired
    private ContinentRepository continentRepository;

    /**
     * Service function that fetches all the available continents from the database.
     * 
     * @return A list of continents.
     */
    public List<ContinentDto> getContinentsList(Sort sorting) {
        List<ContinentDto> data = continentRepository.fetchAllContinents(sorting);
        if (data.isEmpty())
            throw new DataNotFoundException(null);
        return data;
    }

    /**
     * Service function which fetches a single continent based on a given continent
     * id.
     * 
     * @param id The continent id.
     * @return A continent object containing all the related continent data.
     */
    public ContinentDto getContinentById(int id) {
        ContinentDto data = continentRepository.fetchContinentById(id);
        if (data == null)
            throw new DataNotFoundException(null);
        return data;
    }

    /**
     * Service function that fetches a tree of data from continents, regions,
     * countries and stats.
     * 
     * @param pagination A pageable object containing the size, page and sorting
     *                   method to apply on the SQL search.
     * @return A list of object containing all the necessary information.
     */
    public Page<RegionToStatsDto> getContinentsTreeWithStatsMin(Pageable pagination) {
        Page<RegionToStatsDto> data = continentRepository.fetchRegionToStatsDataMinified(pagination);
        if (!data.hasContent())
            throw new DataNotFoundException(null);
        return data;
    }

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
