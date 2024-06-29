import { Component, OnInit } from '@angular/core';
import { CommonModule, NgFor } from '@angular/common';
import { StatisticsService } from './statistics.service';
import { maxGdpStatsList } from './statistics.interface';

@Component({
  selector: 'app-statistics',
  standalone: true,
  imports: [CommonModule, NgFor],
  templateUrl: './statistics.component.html',
  styleUrl: './statistics.component.css'
})
export class StatisticsComponent implements OnInit {
  statistics: maxGdpStatsList;

  constructor(private statisticsService: StatisticsService) {
    this.statistics = [];
  }

  ngOnInit(): void {
    this.getCountryStatisticsMaxGdp();
  }

  async getCountryStatisticsMaxGdp(): Promise<void> {
    this.statistics = await this.statisticsService.getCountryStatisticsMaxGdp();
  }

}
