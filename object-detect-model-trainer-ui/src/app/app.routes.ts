import { Routes } from '@angular/router';
import { ModelManagerComponent } from './view/model-manager/model-manager.component';
import { LoginComponent } from './view/login/login.component';
import { DatasetManagerComponent } from './view/dataset-manager/dataset-manager.component';

export const routes: Routes = [{ path: '', component: LoginComponent }, { path: 'login', component: LoginComponent }, { path: 'models', component: ModelManagerComponent }, { path: 'datasets', component: DatasetManagerComponent }];
