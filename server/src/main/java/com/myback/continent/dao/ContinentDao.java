package com.myback.continent.dao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myback.region.dao.RegionDao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "continents")
public class ContinentDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "continent_id", nullable = true, insertable = false)
    private int continentId;

    @Column(nullable = false)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "continent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RegionDao> regions;

}
