package com.myback.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LanguageDto {
    private int language_id;
    private String language;
}
