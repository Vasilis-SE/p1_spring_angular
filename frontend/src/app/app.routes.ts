import { Routes } from '@angular/router';
import { CountriesComponent } from './countries/countries.component';
import { StatisticsComponent } from './statistics/statistics.component';
import { HomeComponent } from './home/home.component';
import { LangsPerCountryComponent } from './langs-per-country/langs-per-country.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'countries', component: CountriesComponent },
    { path: 'statistics', component: StatisticsComponent },
    { path: 'lpc/:cid', component: LangsPerCountryComponent },
];
