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
    @Column(nullable = true, insertable = false)
    private int continent_id;

    @Column(nullable = false)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "continent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RegionDao> regions;

}
