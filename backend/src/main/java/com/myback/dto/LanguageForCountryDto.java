package com.myback.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Accessors(chain = true)
public class LanguageForCountryDto extends LanguageDto {
    private int official;

    @Builder
    public LanguageForCountryDto(int language_id, String language, int official) {
      super(language_id, language);
      this.official = official;
    }
}
