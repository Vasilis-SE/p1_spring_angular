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

    public List<ContinentDto> getContinentsList(Sort sorting) {
        List<ContinentDao> data = continentRepository.findAll(sorting);
        if (data.isEmpty())
            throw new DataNotFoundException(null);

        return data.stream()
                .map(continent -> modelMapper.map(continent, ContinentDto.class))
                .collect(Collectors.toList());
    }

    public ContinentDto getContinentById(int id) {
        Optional<ContinentDao> data = continentRepository.findById(id);
        if (!data.isPresent())
            throw new DataNotFoundException(null);

        return modelMapper.map(data.get(), ContinentDto.class);
    }

    public ContinentDto createNewContinent(CreateContinentDto newContinent) {
        ContinentDao continentDao = modelMapper.map(newContinent, ContinentDao.class);

        if (continentRepository.findByName(continentDao.getName()).isPresent())
            throw new DataExistsException(null);

        return modelMapper.map(continentRepository.save(continentDao), ContinentDto.class);
    }

    public ContinentDto deleteContinent(int id) {
        Optional<ContinentDao> storedContinent = continentRepository.findById(id);
        if (!storedContinent.isPresent())
            throw new DataNotFoundException(null);

        continentRepository.deleteById(storedContinent.get().getContinentId());
        return modelMapper.map(storedContinent.get(), ContinentDto.class);
    }

}
