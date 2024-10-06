package com.myback.continent.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.myback.continent.dao.ContinentDao;
import com.myback.continent.dto.ContinentDto;
import com.myback.continent.dto.CreateContinentDto;
import com.myback.continent.repository.ContinentRepository;
import com.myback.shared.exceptions.DataExistsException;
import com.myback.shared.exceptions.DataNotFoundException;

import org.springframework.data.domain.Sort;

@Service
public class ContinentService {

    @Autowired
    private ContinentRepository continentRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Service function that fetches all the available continents from the database.
     * 
     * @return A list of continents.
     */
    public List<ContinentDto> getContinentsList(Sort sorting) {
        List<ContinentDao> data = continentRepository.findAll(sorting);
        if (data.isEmpty())
            throw new DataNotFoundException(null);

        return data.stream()
                .map(continent -> modelMapper.map(continent, ContinentDto.class))
                .collect(Collectors.toList());
    }

    /**
     * Service function which fetches a single continent based on a given continent
     * id.
     * 
     * @param id The continent id.
     * @return A continent object containing all the related continent data.
     */
    public ContinentDto getContinentById(int id) {
        Optional<ContinentDao> data = continentRepository.findById(id);
        if (!data.isPresent())
            throw new DataNotFoundException(null);

        return modelMapper.map(data.get(), ContinentDto.class);
    }

    /**
     * Service function that creates a new continent entity with given data.
     * 
     * @param newContinent The new continent that will be created.
     * @return The newly created continent.
     */
    public ContinentDto createNewContinent(CreateContinentDto newContinent) {
        ContinentDao continentDao = modelMapper.map(newContinent, ContinentDao.class);

        if (continentRepository.fetchContinentByName(continentDao.getName()).isPresent())
            throw new DataExistsException(null);

        return modelMapper.map(continentRepository.save(continentDao), ContinentDto.class);
    }

    /**
     * Service function that deletes a continent with a given continent id.
     * 
     * @param id The provided continent id.
     * @return The deleted continent entity.
     */
    public ContinentDto deleteContinent(int id) {
        Optional<ContinentDao> storedContinent = continentRepository.findById(id);
        if (!storedContinent.isPresent())
            throw new DataNotFoundException(null);

        continentRepository.deleteById(storedContinent.get().getContinent_id());
        return modelMapper.map(storedContinent.get(), ContinentDto.class);
    }

}
