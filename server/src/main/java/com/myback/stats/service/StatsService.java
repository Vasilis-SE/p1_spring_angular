package com.myback.stats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.myback.stats.repository.StatsRepository;
import com.myback.shared.exceptions.DataNotFoundException;
import com.myback.stats.dto.StatsPerCountryDto;

@Service
public class StatsService {

    @Autowired
    private StatsRepository statsRepository;

    /**
     * Service function that fetches a tree of data from continents, regions,
     * countries and stats.
     * 
     * @param pagination A pageable object containing the size, page and sorting
     *                   method to apply on the SQL search.
     * @return A list of object containing all the necessary information.
     */
    // public Page<StatsPerCountryDto> getStatsPerCountry(Pageable pagination) {
    //     Page<StatsPerCountryDto> data = statsRepository.fetchStatsPerCountry(pagination);
    //     if (!data.hasContent())
    //         throw new DataNotFoundException(null);
    //     return data;
    // }
}
