import { Component, OnInit } from '@angular/core';
import { ContinentToStatsService } from './continent-to-stats.service';
import { continentToStatsList } from './continent-to-stats.interface';
import { CommonModule, NgFor } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-continent-to-stats',
  standalone: true,
  imports: [CommonModule, NgFor, FormsModule],
  templateUrl: './continent-to-stats.component.html',
  styleUrl: './continent-to-stats.component.css'
})
export class ContinentToStatsComponent implements OnInit {
  continentToStatsDisplay: continentToStatsList;
  continentToStats: continentToStatsList;

  errorMessage: string;

  page: number;
  pageSize: number;
  numOfPages: number;

  filterRegion: string;
  filterFromYear: number;
  filterToYear: number;

  constructor(private continentToStatsService: ContinentToStatsService) {
    this.continentToStatsDisplay = [];
    this.continentToStats = [];

    this.errorMessage = '';

    this.page = 1;
    this.pageSize = 300;
    this.numOfPages = 0;

    this.filterRegion = '';
    this.filterFromYear = -1;
    this.filterToYear = -1;
  }

  async ngOnInit(): Promise<void> {
    await this.getContinentToStatsTreeMinified();
  }

  resetDisplay(): void {
    this.setDisplay(JSON.parse(JSON.stringify(this.continentToStats)));
  }

  setDisplay(data: continentToStatsList): void {
    this.continentToStatsDisplay = data;

    if(this.continentToStatsDisplay.length === 0) {
      this.errorMessage = `No data found with the given filters...`;
      return;
    }    

    this.page = 1;
    this.numOfPages = Math.ceil(this.continentToStatsDisplay.length / this.pageSize);
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

  searchByFilters(): void {
    this.errorMessage = '';

    if (!this.filterRegion && (this.filterFromYear == -1 || this.filterToYear == -1)) {
      this.filterRegion = '';
      this.filterFromYear = -1;
      this.filterToYear = -1;

      this.resetDisplay();
      return;
    }

    let tempRes = this.continentToStats;

    if (this.filterRegion)
      tempRes = tempRes.filter((cts) => cts.region_name == this.filterRegion);

    if (this.filterFromYear != -1 && this.filterToYear != -1) {
      if(this.filterToYear < this.filterFromYear) {
        this.errorMessage = `From error! 'to' year cannot be greater than 'from' year. Enter a valid range...`;
        return;
      }

      tempRes = tempRes.filter((cts) => cts.year >= this.filterFromYear && cts.year <= this.filterToYear);
    }

    this.setDisplay(tempRes);
  }

}
