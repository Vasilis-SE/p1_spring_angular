package com.myback.dto;

import java.util.List;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LanguagesPerCountryDto {
    private String name;
    private List<LanguageForCountryDto> languages;
}
