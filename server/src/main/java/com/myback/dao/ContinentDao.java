package com.myback.dao;

import java.util.List;
import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "continents")
public class ContinentDao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int continent_id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "continent_id", fetch = FetchType.LAZY)
    private List<RegionDao> regions;

}
