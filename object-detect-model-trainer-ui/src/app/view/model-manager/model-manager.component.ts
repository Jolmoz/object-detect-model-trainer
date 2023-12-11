import { Component, OnInit } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { MatListModule } from '@angular/material/list';
import { ModelManagerClientService } from '../../rest-api-client/model-manager-client.service';
import { PopupsControl } from '../../services/popups-control';
import { EditorComponent } from '../dialogs/editor/editor.component';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-model-manager',
  standalone: true,
  imports: [MatListModule, MatTableModule, MatButtonModule],
  templateUrl: './model-manager.component.html',
  styleUrl: './model-manager.component.css'
})
export class ModelManagerComponent implements OnInit {
  models: any[] = []
  datasets: any[] = []
  displayedColumns: string[] = ['id', 'modelName', 'architecture', 'modelDescription', 'userAccessCreator', 'userAccessLastEditor'];
  constructor(private modelManagerClientService: ModelManagerClientService,
    private popUpsControl: PopupsControl) {

  }
  ngOnInit(): void {
    this.getAllModels()
  }

  getAllDataSets() {
    this.popUpsControl.openSpinnerDialog('Cargando set de datos')
    this.modelManagerClientService.getAllDataSets().subscribe({
      next: (value: any[]) => {
        this.datasets = value;
        this.popUpsControl.closeAnyDialog()
      }, error(err) {
        console.log(err);
        this.popUpsControl.closeAnyDialog()
      },
    })
  }

  getAllModels() {
    this.popUpsControl.openSpinnerDialog('Cargando modelos')
    this.modelManagerClientService.getAllModels().subscribe({
      next: (value: any[]) => {
        this.popUpsControl.closeAnyDialog()
        this.models = value;
        this.getAllDataSets()
      }, error(err) {
        console.log(err);
        this.popUpsControl.closeAnyDialog()
      },
    })
  }

  saveModel(model) {
    return this.modelManagerClientService.saveModel(model)
  }

  deleteModel(model) {
    return this.modelManagerClientService.deleteModel(model)
  }


  editModel(model?: any) {
    if (!model) {
      model = {
        "modelName": "",
        "modelPath": "/home/",
        "modelDescription": "",
        "architecture": "faster_rcnn",
        "epochs": "10",
        "learningRate": 5,
        "batchSize": 16,
        "trainingProcess": 100,
        "dataSets": [],
        "modelType": "OBJECTS",
        "version": 1
      }
    }
    let data = {
      width: this.popUpsControl.WIDTH_DEFAULT,
      height: this.popUpsControl.HEIGHT_DEFAULT,
      data: {
        entity: model,
        title: 'Editor de Modelo ID: ' + (model.id == undefined ? 'Nuevo' : model.id),
        editableFields: ['modelName', 'modelPath', 'modelDescription', 'architecture', 'epochs', 'learningRate', 'batchSize', 'modelType'],
        allarraysItems: [{ label: 'dataSets', values: this.datasets }]
      }
    }
    this.popUpsControl.openAnyDialog(EditorComponent, data).afterClosed().subscribe(
      returnedData => {
        if (returnedData && returnedData?.action == 'save') {
          this.popUpsControl.openSpinnerDialog('Guardando')
          this.saveModel(returnedData.data).subscribe(
            {
              next: () => {
                this.popUpsControl.closeAnyDialog()
                this.getAllModels();
              }, error(err) {
                console.log(err);
                this.popUpsControl.closeAnyDialog()
              },
            }
          );
        } else if (returnedData && returnedData?.action == 'delete') {
          this.popUpsControl.openSpinnerDialog('Eliminando')
          this.deleteModel(returnedData.data).subscribe(
            {
              next: () => {
                this.popUpsControl.closeAnyDialog()
                this.getAllModels();
              }, error(err) {
                console.log(err);
                this.popUpsControl.closeAnyDialog()
              },
            }
          );
        } else {
          this.getAllModels();
        }

      });;
  }
}
