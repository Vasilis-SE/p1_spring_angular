package com.myback.language.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myback.country.dao.CountryDao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "country_languages")
public class CountryLanguageDao {

    @EmbeddedId
    @JsonIgnore
    private CountryLanguageIdDao id;
    
    @ManyToOne
    @MapsId("country_id") // From the embeddable id.
    @JsonBackReference
    @JoinColumn(name = "country_id")
    private CountryDao country;

    @ManyToOne
    @MapsId("language_id") // From the embeddable id.
    @JsonManagedReference
    @JoinColumn(name = "language_id")
    private LanguageDao language;

    @Column(nullable = false)
    private int official;

}
