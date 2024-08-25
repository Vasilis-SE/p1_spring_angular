package com.myback.dao;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "languages")
public class LanguagesDao {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int language_id;

    @Column(nullable = false)
    private String language;

    // @OneToMany(mappedBy = "language")
    // private List<CountryLanguageDao> countryLanguages;

}
