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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id", nullable = false, updatable = false)
    private int regionId;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "continent_id")
    private ContinentDao continent;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "region", fetch = FetchType.LAZY)
    private List<CountryDao> countries;

}
