package com.myback.dao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "country_languages")
@IdClass(CountryLanguageId.class)
public class CountryLanguageDao {
    
    @Id
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CountryDao.class)
    @JoinColumn(name = "country_id")
    private CountryDao country;

    @Id
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = LanguagesDao.class)
    @JoinColumn(name = "language_id")
    private LanguagesDao language;

    @Column(nullable = false)
    private int official;

}
