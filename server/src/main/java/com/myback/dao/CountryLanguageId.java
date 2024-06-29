package com.myback.dao;

import lombok.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CountryLanguageId {
    private CountryDao country;
    private LanguagesDao language;
}
