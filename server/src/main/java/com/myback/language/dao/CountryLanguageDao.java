package com.myback.language.dao;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "country_languages")
public class CountryLanguageDao {

    @EmbeddedId
    private CountryLanguageId id;

    // @ManyToOne
    // @JoinColumn(name = "country_id", insertable = false, updatable = false)
    // private CountryDao country;

    @ManyToOne
    @JoinColumn(name = "language_id", insertable = false, updatable = false)
    private LanguagesDao language;

    @Column(nullable = false)
    private int official;

}
