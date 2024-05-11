export interface continentToStats {
    continent_name: string;
    region_name: string;
    country_name: string;
    year: number;
    population: number;
    gdp: number;
}

export type continentToStatsList = Array<continentToStats>;