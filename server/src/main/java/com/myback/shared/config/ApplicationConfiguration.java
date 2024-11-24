package com.myback.shared.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.myback.continent.dao.ContinentDao;
import com.myback.continent.dto.CreateContinentDto;
import com.myback.region.dao.RegionDao;
import com.myback.region.dto.CreateRegionDto;

@Configuration
public class ApplicationConfiguration {

    private ModelMapper modelMapper;

    public ApplicationConfiguration() {
        modelMapper = new ModelMapper();
    }

    @Bean
    public ModelMapper modelMapper() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        this.continentMappings();
        this.regionMappings();

        return modelMapper;
    }

    private void continentMappings() {
        modelMapper.typeMap(CreateContinentDto.class, ContinentDao.class)
                .addMappings(mapper -> mapper.skip(ContinentDao::setRegions));
    }

    private void regionMappings() {
        modelMapper.typeMap(CreateRegionDto.class, RegionDao.class)
                .addMappings(mapper -> mapper.skip(RegionDao::setRegionId));
    }

}
