import { Component } from '@angular/core';
import { RouterLink, RouterOutlet, RouterLinkActive } from '@angular/router';
import { CountriesComponent } from './countries/countries.component';
import { MenuComponent } from "./menu/menu.component";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CommonModule, NgFor } from '@angular/common';

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [
        RouterLink,
        RouterLinkActive,
        NgbModule,
        CommonModule,
        NgFor,
        RouterOutlet,
        CountriesComponent,
        MenuComponent
    ]
})
export class AppComponent {
  title = 'appName';
}
