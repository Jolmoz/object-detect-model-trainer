import { Component, OnInit } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { MatListModule } from '@angular/material/list';
import { ModelManagerClientService } from '../../rest-api-client/model-manager-client.service';
import { PopupsControl } from '../../services/popups-control';
import { EditorComponent } from '../dialogs/editor/editor.component';
import { MatButtonModule } from '@angular/material/button';
import { MatTabsModule } from '@angular/material/tabs';

@Component({
  selector: 'app-dataset-manager',
  standalone: true,
  imports: [MatListModule, MatTableModule, MatButtonModule, MatTabsModule],
  templateUrl: './dataset-manager.component.html',
  styleUrl: './dataset-manager.component.css'
})
export class DatasetManagerComponent implements OnInit {
  datasets: any[] = []
  assetDocuments: any[] = []
  displayedDataSetColumns: string[] = ['id', 'dataSetName', 'dataSetDescription', 'userAccessCreator', 'userAccessLastEditor'];
  displayedAssetDocumentColumns: string[] = ['id', 'name', 'path', 'format'];
  constructor(private modelManagerClientService: ModelManagerClientService,
    private popUpsControl: PopupsControl) {

  }
  ngOnInit(): void {
    this.getAllDataSets()
    this.getAllAssetDocuments()
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
    let assets = []

    if (!dataset) {
      dataset = {
        "dataSetName": "",
        "dataSetDescription": "",
        "assets": [],
        "tags": [],
        "version": 1
      }
    } else {
      for (let assetDocument of this.assetDocuments) {
        assets.push({ 'assetDocument': assetDocument, 'dataSetId': dataset.id, 'name': assetDocument.name })
      }
    }

    let data = {
      width: this.popUpsControl.WIDTH_DEFAULT,
      height: this.popUpsControl.HEIGHT_DEFAULT,
      data: {
        entity: dataset,
        title: 'Editor de Modelo ID: ' + (dataset.id == undefined ? 'Nuevo' : dataset.id),
        editableFields: ['dataSetName', 'dataSetDescription'],
        editableChips: { 'tags': ['name', 'color'] },
        allarraysItems: [{ label: 'assets', values: assets }]
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

  getAllAssetDocuments() {
    this.modelManagerClientService.getAllAssetDocuments().subscribe({
      next: (value: any[]) => {
        this.assetDocuments = value;
      }, error(err) {
        console.log(err);
      },
    })
  }

  saveAssetDocument(assetDocument) {
    return this.modelManagerClientService.saveAssetDocument(assetDocument)
  }

  deleteAssetDocument(assetDocument) {
    return this.modelManagerClientService.deleteAssetDocument(assetDocument)
  }


  editAssetDocument(assetDocument?: any) {
    if (!assetDocument) {
      assetDocument = {
        "name": "",
        "format": "",
        "height": 0,
        "path": "",
        "state": 0,
        "type": 0,
        "width": 0
      }
    }
    let data = {
      width: this.popUpsControl.WIDTH_DEFAULT,
      height: this.popUpsControl.HEIGHT_DEFAULT,
      data: {
        entity: assetDocument,
        title: 'Editor de Modelo ID: ' + (assetDocument.id == undefined ? 'Nuevo' : assetDocument.id),
        editableFields: ['name']
      }
    }
    this.popUpsControl.openAnyDialog(EditorComponent, data).afterClosed().subscribe(
      returnedData => {
        if (returnedData && returnedData?.action == 'save') {
          this.saveAssetDocument(returnedData.data).subscribe(
            {
              next: () => {
                this.getAllAssetDocuments();
              }, error(err) {
                console.log(err);
              },
            }
          );
        } else if (returnedData && returnedData?.action == 'delete') {
          this.deleteAssetDocument(returnedData.data).subscribe(
            {
              next: () => {
                this.getAllAssetDocuments();
              }, error(err) {
                console.log(err);
              },
            }
          );
        } else {
          this.getAllAssetDocuments();
        }

      });;
  }
}
