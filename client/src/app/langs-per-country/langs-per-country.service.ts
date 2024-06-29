import { Injectable } from '@angular/core';
import { countryLanguagesList } from './langs-per-country.interface';

@Injectable({
  providedIn: 'root'
})
export class LangsPerCountryService {
  baseUrl = "http://localhost:8080/api";

  constructor() { }

  async getLanguagesByCountry(cid: number): Promise<countryLanguagesList> {
    const response = await fetch(`${this.baseUrl}/language/${cid}`);
    return await response.json();
  }
}
