package com.myback.country.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.myback.region.dao.RegionDao;
import com.myback.stats.dao.StatsDao;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "countries")
public class CountryDao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int country_id;
    
    @Column(nullable = true)
    private String name;
    
    @Column(nullable = false)
    private int area;

    @Column(nullable = true)
    @CreatedDate
    private Date national_day;

    @Column(nullable = false)
    private String country_code2;

    @Column(nullable = false)
    private String country_code3;

    @ManyToOne
    @JsonBackReference    
    @JoinColumn(name="region_id")
    private RegionDao region;

    // @OneToMany(cascade = CascadeType.ALL, mappedBy="country_id", fetch = FetchType.LAZY)
    // private List<StatsDao> statistics;

//     @OneToMany(cascade = CascadeType.ALL, mappedBy="country_id", fetch = FetchType.LAZY)
//     private List<CountryLanguageDao> languages;
}
