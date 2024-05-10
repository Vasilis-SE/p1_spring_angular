package com.myback.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageForCountryDto extends LanguageDto {
    private int official;

    public LanguageForCountryDto(int language_id, String language, int official) {
      super(language_id, language);
      this.official = official;
    }
}
