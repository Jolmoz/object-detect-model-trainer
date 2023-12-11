import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterOutlet } from '@angular/router';
import { ModelManagerComponent } from './view/model-manager/model-manager.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { RouterModule } from '@angular/router';
import { NgIconComponent, provideIcons } from '@ng-icons/core';
import { bootstrapGithub } from '@ng-icons/bootstrap-icons';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, ModelManagerComponent, MatToolbarModule, MatIconModule, MatButtonModule, MatSidenavModule, MatListModule, RouterModule, NgIconComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  viewProviders: [provideIcons({ bootstrapGithub })]
})
export class AppComponent {
  showFiller = false;
  menuList = [{ 'label': 'Modelos', 'path': '/models', 'icon': 'auto_fix_high' }, { 'label': 'Datasets', 'path': '/datasets', 'icon': 'dataset' }]

  constructor(public router: Router){ }
}
