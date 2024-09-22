package com.myback.continent.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.myback.continent.dao.ContinentDao;
import com.myback.continent.dto.ContinentDto;
import com.myback.continent.repository.ContinentRepository;
import com.myback.shared.exceptions.DataNotFoundException;

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

    public ContinentDto createNewContinent(ContinentDto newContinent) {
        // if(newContinent == null)


        ModelMapper modelMapper = new ModelMapper();
        ContinentDao continentDao = modelMapper.map(newContinent, ContinentDao.class);
        
        return modelMapper.map(continentRepository.save(continentDao), ContinentDto.class);
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
