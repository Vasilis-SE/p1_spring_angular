package com.myback.language.dao;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CountryLanguageId implements Serializable {
    private int country_id;
    private int language_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguageId that = (CountryLanguageId) o;
        return country_id == that.country_id && language_id == that.language_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(country_id, language_id);
    }
}
