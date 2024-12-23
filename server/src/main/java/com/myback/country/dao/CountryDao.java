package com.myback.country.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myback.language.dao.CountryLanguageDao;
import com.myback.region.dao.RegionDao;
import com.myback.stats.dao.StatsDao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "countries")
public class CountryDao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false, updatable = false)
    private int countryId;
    
    @Column(nullable = true)
    private String name;
    
    @Column(nullable = false)
    private int area;

    @Column(name = "national_day", nullable = true)
    @CreatedDate
    private Date nationalDay;

    @Column(name = "country_code2", nullable = false)
    private String countryCode2;

    @Column(name = "country_code3", nullable = false)
    private String countryCode3;

    @ManyToOne
    @JsonBackReference    
    @JoinColumn(name="region_id")
    private RegionDao region;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy="country", fetch = FetchType.LAZY)
    private List<StatsDao> statistics;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy="country", fetch = FetchType.LAZY)
    private List<CountryLanguageDao> country_languages;
}
