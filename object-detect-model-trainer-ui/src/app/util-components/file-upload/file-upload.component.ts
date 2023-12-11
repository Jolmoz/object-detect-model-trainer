import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';

@Component({
  selector: 'app-file-upload',
  standalone: true,
  imports: [MatButtonModule, MatInputModule],
  templateUrl: './file-upload.component.html',
  styleUrl: './file-upload.component.css'
})
export class FileUploadComponent {
  selectedFile: File | null = null;

  constructor(private dialogRef: MatDialogRef<FileUploadComponent>) {

  }

  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0] as File;
  }

  uploadFile(): void {
    if (!this.selectedFile) {
      console.error('Seleccione un archivo antes de intentar subirlo.');
      return;
    }

    // Convertir el archivo a base64
    this.convertFileToBase64(this.selectedFile).then((base64) => {
      // Enviar el archivo en formato base64 por REST
      this.dialogRef.close(base64);
    });
  }

  convertFileToBase64(file: File): Promise<string> {
    return new Promise<string>((resolve, reject) => {
      const reader = new FileReader();
      reader.onload = () => resolve(reader.result as string);
      reader.onerror = (error) => reject(error);
      reader.readAsDataURL(file);
    });
  }

}

