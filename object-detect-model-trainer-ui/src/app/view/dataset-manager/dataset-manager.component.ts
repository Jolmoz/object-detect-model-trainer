import { Component, OnInit } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { MatListModule } from '@angular/material/list';
import { ModelManagerClientService } from '../../rest-api-client/model-manager-client.service';
import { PopupsControl } from '../../services/popups-control';
import { EditorComponent } from '../dialogs/editor/editor.component';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-dataset-manager',
  standalone: true,
  imports: [MatListModule, MatTableModule, MatButtonModule],
  templateUrl: './dataset-manager.component.html',
  styleUrl: './dataset-manager.component.css'
})
export class DatasetManagerComponent implements OnInit {
  datasets: any[] = []
  displayedColumns: string[] = ['id', 'dataSetName', 'dataSetDescription', 'userAccessCreator', 'userAccessLastEditor'];
  constructor(private modelManagerClientService: ModelManagerClientService,
    private popUpsControl: PopupsControl) {

  }
  ngOnInit(): void {
    this.getAllDataSets()
  }

  getAllDataSets() {
    this.modelManagerClientService.getAllDataSets().subscribe({
      next: (value: any[]) => {
        this.datasets = value;
      }, error(err) {
        console.log(err);
      },
    })
  }

  saveDataSet(dataset) {
    return this.modelManagerClientService.saveDataSet(dataset)
  }

  deleteDataSet(dataset) {
    return this.modelManagerClientService.deleteDataSet(dataset)
  }


  editDataSet(dataset?: any) {
    if (!dataset) {
      dataset = {
        "dataSetName": "",
        "dataSetDescription": "",
        "assets": [],
        "tags": [],
        "version": 1
      }
    }
    let data = {
      width: this.popUpsControl.WIDTH_DEFAULT,
      height: this.popUpsControl.HEIGHT_DEFAULT,
      data: {
        entity: dataset,
        title: 'Editor de Modelo ID: ' + (dataset.id == undefined ? 'Nuevo' : dataset.id),
        editableFields: ['dataSetName', 'dataSetDescription'],
        editableChips: { 'tags': ['name', 'color'] }
      }
    }
    this.popUpsControl.openAnyDialog(EditorComponent, data).afterClosed().subscribe(
      returnedData => {
        if (returnedData && returnedData?.action == 'save') {
          this.saveDataSet(returnedData.data).subscribe(
            {
              next: () => {
                this.getAllDataSets();
              }, error(err) {
                console.log(err);
              },
            }
          );
        } else if (returnedData && returnedData?.action == 'delete') {
          this.deleteDataSet(returnedData.data).subscribe(
            {
              next: () => {
                this.getAllDataSets();
              }, error(err) {
                console.log(err);
              },
            }
          );
        } else {
          this.getAllDataSets();
        }

      });;
  }
}
