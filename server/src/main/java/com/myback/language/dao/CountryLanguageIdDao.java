package com.myback.language.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryLanguageIdDao {

    @Column(name = "country_id")
    private int country_id;

    @Column(name = "language_id")
    private int language_id;

}
