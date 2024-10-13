package com.myback.region.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myback.region.dao.RegionDao;
import com.myback.region.dto.RegionDto;
import com.myback.region.repository.RegionRepository;
import com.myback.shared.exceptions.DataNotFoundException;

@Service
public class RegionService {

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

}
