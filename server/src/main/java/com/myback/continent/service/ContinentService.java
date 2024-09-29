package com.myback.continent.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.myback.continent.dao.ContinentDao;
import com.myback.continent.dto.ContinentDto;
import com.myback.continent.dto.CreateContinentDto;
import com.myback.continent.repository.ContinentRepository;
import com.myback.shared.exceptions.DataExists;
import com.myback.shared.exceptions.DataNotFoundException;

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
     * Service function that creates a new continent entity with given data.
     * 
     * @param newContinent The new continent that will be created.
     * @return The newly created continent. 
     */
    public ContinentDto createNewContinent(CreateContinentDto newContinent) {
        ModelMapper modelMapper = new ModelMapper();
        ContinentDao continentDao = modelMapper.map(newContinent, ContinentDao.class);

        if (continentRepository.fetchContinentByName(continentDao.getName()).isPresent())
            throw new DataExists(null);

        return modelMapper.map(continentRepository.save(continentDao), ContinentDto.class);
    }

}
