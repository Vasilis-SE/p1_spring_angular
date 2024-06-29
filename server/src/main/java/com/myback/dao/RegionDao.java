package com.myback.dao;

import java.util.List;

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

    @OneToMany(mappedBy="region_id")
    private List<CountryDao> countries;
    

}
