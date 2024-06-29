import { Injectable } from '@angular/core';
import { maxGdpStatsList } from './statistics.interface';

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {
  baseUrl = "http://localhost:8080/api";

  constructor() { }

  async getCountryStatisticsMaxGdp(): Promise<maxGdpStatsList> {
    const response = await fetch(`${this.baseUrl}/country/stats/mgdp`);
    return await response.json();
  }
}
