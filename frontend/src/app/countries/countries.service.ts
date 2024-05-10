import { Injectable } from '@angular/core';
import { countriesList } from './countries.interface';

@Injectable({
  providedIn: 'root'
})
export class CountriesService {
  baseUrl = "http://localhost:8080/api";

  constructor() { }

  async getCountries(): Promise<countriesList> {
    const response = await fetch(`${this.baseUrl}/country`);
    return await response.json();
  }

}
