import { Component } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import {
  FormControl,
  Validators,
  FormsModule,
  ReactiveFormsModule,
} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { PopupsControl } from '../../services/popups-control';
import { StorageService } from '../../services/storage.service';
import { Router } from '@angular/router';
import { AuthenticationClientService } from '../../rest-api-client/authentication-client.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, MatFormFieldModule, MatInputModule, ReactiveFormsModule, MatButtonModule, MatIconModule, MatDividerModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  userNameFormControl = new FormControl('', [Validators.required]);
  passwordFormControl = new FormControl('', [Validators.required]);
  hidePassword = true;

  constructor(private authenticationClientService: AuthenticationClientService,
    private popUpsControl: PopupsControl,
    private storageService: StorageService,
    private router: Router) {

  }

  login() {
    this.popUpsControl.openSpinnerDialog('Iniciando sesión')
    this.authenticationClientService.loginAuthentication('Basic ' + btoa(this.userNameFormControl.value + ":" + this.passwordFormControl.value)).subscribe(
      {
        next: (token: string) => {
          this.storageService.set('token', token);
          this.popUpsControl.closeAnyDialog();
          this.router.navigateByUrl('/models')
        }, error: () => {
          this.popUpsControl.closeAnyDialog();
          this.popUpsControl.openSnackBar('Credenciales incorrectas', 'OK', 5)
        }
      })
  }
}
