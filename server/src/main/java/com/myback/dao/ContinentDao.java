package com.myback.dao;

import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int continent_id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy="continent_id")
    private List<RegionDao> regions;

}
