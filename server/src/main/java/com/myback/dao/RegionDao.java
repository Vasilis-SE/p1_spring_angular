package com.myback.dao;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
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
