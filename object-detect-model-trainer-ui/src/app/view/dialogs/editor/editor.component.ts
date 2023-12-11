import { Component, Inject } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatChipsModule } from '@angular/material/chips';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { MatIconModule } from '@angular/material/icon';

import {
  FormControl,
  Validators,
  FormsModule,
  ReactiveFormsModule,
} from '@angular/forms';

@Component({
  selector: 'app-editor',
  standalone: true,
  imports: [MatCardModule, MatButtonModule, FormsModule, MatFormFieldModule, MatInputModule, ReactiveFormsModule, MatButtonModule, MatChipsModule, MatAutocompleteModule, MatIconModule],
  templateUrl: './editor.component.html',
  styleUrl: './editor.component.css'
})
export class EditorComponent {
  separatorKeysCodes: number[] = [ENTER, COMMA]
  entity: any;
  labels: string[] = []
  inputs: FormControl[] = []
  allarraysItems = []
  arraysItems = []

  constructor(@Inject(MAT_DIALOG_DATA) public data,
    private dialogRef: MatDialogRef<EditorComponent>) {
    this.entity = data.entity
    this.allarraysItems = data.allarraysItems

    for (let atribute of Object.keys(this.entity)) {
      let label = atribute
      let value = this.entity[atribute]
      let input: FormControl;

      if (Array.isArray(value)) {
        let array = {
          label: label,
          values: value
        }

        this.arraysItems.push(array)
      } else if (typeof value !== 'object' && data.editableFields.includes(label)) {
        input = new FormControl(value, []);
        this.labels.push(label)
        this.inputs.push(input)
      }
    }
    console.log(this.entity);
    
  }

  addItem(event, label) {
    let item = event.option.value;
    for (let arrayItem of this.arraysItems) {
      if (arrayItem.label == label) {
        arrayItem.values.push(item)
      }
    }
  }

  removeItem(item, label) {
    for (let arrayItem of this.arraysItems) {
      if (arrayItem.label == label) {
        arrayItem.values = arrayItem.values.filter(x => x.id !== item.id);
      }
    }
  }

  getItemName(item) {
    for (let atr of Object.keys(item)) {
      if (atr.toLowerCase().includes('name')) {
        return item[atr]
      }
    }
    return 'nofound'
  }

  refreshEntity() {
    for (let i = 0; i < this.inputs.length; i++) {
      let input = this.inputs[i]
      let label = this.labels[i]
      if (this.data.editableFields.includes(label)) {
        this.entity[label] = input.value
      }
    }

    for (let arrayItem of this.arraysItems) {
      this.entity[arrayItem.label] = arrayItem.values
    }
  }

  submit() {
    this.refreshEntity();
    this.dialogRef.close({ 'action': 'save', 'data': this.entity });
  }

  delete() {
    this.refreshEntity();
    this.dialogRef.close({ 'action': 'delete', 'data': this.entity });
  }
}
