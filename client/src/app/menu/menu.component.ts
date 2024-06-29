import { Component } from '@angular/core';
import { MatMenuModule } from '@angular/material/menu';

@Component({
  selector: 'app-menu',
  standalone: true,
  imports: [
    MatMenuModule
  ],
  styleUrl: './menu.component.css',
  templateUrl: './menu.component.html'
})
export class MenuComponent {

}
