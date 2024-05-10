import { Component, OnInit } from '@angular/core';
import { CommonModule, NgFor } from '@angular/common';
import { LangsPerCountryService } from './langs-per-country.service';
import { ActivatedRoute } from '@angular/router';
import { countryLanguagesList } from './langs-per-country.interface';

@Component({
  selector: 'app-langs-per-country',
  standalone: true,
  imports: [CommonModule, NgFor],
  templateUrl: './langs-per-country.component.html',
  styleUrl: './langs-per-country.component.css'
})
export class LangsPerCountryComponent implements OnInit {
  langsOfCountry: countryLanguagesList;

  constructor(private langsPerCountryService: LangsPerCountryService, private route: ActivatedRoute) {
    this.langsOfCountry = { name: '', languages: [] };
  }

  ngOnInit(): void {
    this.getLanguagesByCountry();
  }

  async getLanguagesByCountry(): Promise<void> {
    this.langsOfCountry = await this.langsPerCountryService.getLanguagesByCountry(Number(this.route.snapshot.paramMap.get('cid')));
  }
}
