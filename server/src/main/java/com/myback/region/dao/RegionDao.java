package com.myback.region.dao;

import java.util.List;

import com.myback.country.dao.CountryDao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "regions")
public class RegionDao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int region_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int continent_id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="region_id", fetch = FetchType.LAZY)
    private List<CountryDao> countries;
    
}
