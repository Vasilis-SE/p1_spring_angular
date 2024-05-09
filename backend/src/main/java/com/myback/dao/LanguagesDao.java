package com.myback.dao;

import java.util.Set;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "languages")
public class LanguagesDao {
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int language_id;

    @OneToMany(mappedBy="language_id")
    private Set<CountryLanguageDao> country_langs;

    @Column(nullable = false)
    private String language;

}
