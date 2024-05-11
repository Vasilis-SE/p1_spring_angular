import { Component, OnInit } from '@angular/core';
import { ContinentToStatsService } from './continent-to-stats.service';
import { continentToStatsList } from './continent-to-stats.interface';
import { CommonModule, NgFor } from '@angular/common';

@Component({
  selector: 'app-continent-to-stats',
  standalone: true,
  imports: [CommonModule, NgFor],
  templateUrl: './continent-to-stats.component.html',
  styleUrl: './continent-to-stats.component.css'
})
export class ContinentToStatsComponent implements OnInit {
  continentToStatsDisplay: continentToStatsList;
  continentToStats: continentToStatsList;

  constructor(private continentToStatsService: ContinentToStatsService) {
    this.continentToStatsDisplay = [];
    this.continentToStats = [];
  }

  ngOnInit(): void {
    this.getContinentToStatsTreeMinified();
  }

  resetDisplay(): void {
    this.continentToStatsDisplay = JSON.parse(JSON.stringify(this.continentToStats));
  }

  async getContinentToStatsTreeMinified(): Promise<void> {
    this.continentToStats = await this.continentToStatsService.getContinentToStatsTreeMinified();
    this.resetDisplay();
  }

  getListOfDistinctRegions(): string[] {
    return [...new Set(this.continentToStats.map(item => item.region_name))];
  }

  getListOfDistinctYears(): number[] {
    return [...new Set(this.continentToStats.map(item => item.year))].sort();
  }

  searchByRegion(filter: string): void {
    if (!filter) {
      this.resetDisplay();
      return;
    }

    this.continentToStatsDisplay = this.continentToStats.filter((cts) => cts.region_name == filter);
  }

}
