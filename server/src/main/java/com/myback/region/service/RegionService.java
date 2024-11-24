package com.myback.region.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myback.continent.dao.ContinentDao;
import com.myback.continent.repository.ContinentRepository;
import com.myback.region.dao.RegionDao;
import com.myback.region.dto.CreateRegionDto;
import com.myback.region.dto.RegionDto;
import com.myback.region.repository.RegionRepository;
import com.myback.shared.exceptions.DataExistsException;
import com.myback.shared.exceptions.DataNotFoundException;

@Service
public class RegionService {

    @Autowired
    private ContinentRepository continentRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<RegionDto> getRegionsList(Sort sorting) {
        List<RegionDao> data = regionRepository.findAll(sorting);
        if (data.isEmpty())
            throw new DataNotFoundException(null);

        return data.stream()
                .map(region -> modelMapper.map(region, RegionDto.class))
                .collect(Collectors.toList());
    }

    public RegionDto getRegionById(Integer id) {
        Optional<RegionDao> data = regionRepository.findById(id);
        if (!data.isPresent())
            throw new DataNotFoundException(null);

        return modelMapper.map(data.get(), RegionDto.class);
    }

    public RegionDto createNewRegion(CreateRegionDto createRegionDto) {
        Optional<ContinentDao> continent = continentRepository.findById(createRegionDto.getContinentId());
        if (!continent.isPresent())
            throw new DataNotFoundException(null);

        if (regionRepository.findByName(createRegionDto.getName()).isPresent())
            throw new DataExistsException(null);

        RegionDao newRegion = modelMapper.map(createRegionDto, RegionDao.class);
        newRegion.setContinent(continent.get());

        return modelMapper.map(regionRepository.save(newRegion), RegionDto.class);
    }

    public RegionDto deleteRegion(int id) {
        Optional<RegionDao> storedRegion = regionRepository.findById(id);
        if (!storedRegion.isPresent())
            throw new DataNotFoundException(null);

        regionRepository.deleteById(storedRegion.get().getRegionId());
        return modelMapper.map(storedRegion.get(), RegionDto.class);
    }

}
