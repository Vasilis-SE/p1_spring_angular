import { Injectable } from '@angular/core';
import { continentToStatsList } from './continent-to-stats.interface';

@Injectable({
  providedIn: 'root'
})
export class ContinentToStatsService {
  baseUrl = "http://localhost:8080/api";

  constructor() { }

  async getContinentToStatsTreeMinified(): Promise<continentToStatsList> {
    const response = await fetch(`${this.baseUrl}/continent/min`);
    return await response.json();
  }
}
