package com.myback.dao;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "country_languages")
public class CountryLanguageDao {
    
    @Id
    @Column(nullable = false)
    private int country_id;
    
    @Id
    @Column(nullable = false)
    private int language_id;

    @Column(nullable = false)
    private int official;

}
