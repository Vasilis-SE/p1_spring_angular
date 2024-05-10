import { Component, OnInit } from '@angular/core';
import { CountriesService } from './countries.service';
import { CommonModule, NgFor } from '@angular/common';
import { countriesList } from './countries.interface';

@Component({
  selector: 'countries',
  standalone: true,
  imports: [ CommonModule, NgFor ],
  styleUrl: './countries.component.css',
  templateUrl: './countries.component.html'
})
export class CountriesComponent implements OnInit {
  countries: countriesList;

  constructor(private countriesService: CountriesService) {
    this.countries = [];
  }

  ngOnInit(): void {
    this.getCountries();
  }

  async getCountries(): Promise<void> {
    this.countries = await this.countriesService.getCountries();
  }
}
