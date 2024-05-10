export interface countryLanguage {
    language: string;
    language_id: number;
    official: number;
}

export interface countryLanguagesList {
    name: string,
    languages: countryLanguage[]
}
