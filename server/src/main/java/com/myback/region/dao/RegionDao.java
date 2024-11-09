package com.myback.region.dao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myback.continent.dao.ContinentDao;
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

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "continent_id")
    private ContinentDao continent;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "region", fetch = FetchType.LAZY)
    private List<CountryDao> countries;

    public RegionDao(int region_id, String name) {
        this.region_id = region_id;
        this.name = name;
    }
}
