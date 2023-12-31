import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environment/environments';
import { StorageService } from '../services/storage.service';

@Injectable({
  providedIn: 'root'
})
export class ModelManagerClientService {

  httpHeaders: HttpHeaders = new HttpHeaders();

  constructor(private http: HttpClient,
    private appStorage: StorageService) { }

  getAllModels(): Observable<any> {
    this.httpHeaders = new HttpHeaders({ token: this.appStorage.get("token") });
    return this.http.get<any[]>(environment.serverBaseUrl + 'api/ModelManagerServerApi/getAllModels', { headers: this.httpHeaders });
  }

  saveModel(model): Observable<any> {
    this.httpHeaders = new HttpHeaders({ token: this.appStorage.get("token") });
    return this.http.post(environment.serverBaseUrl + 'api/ModelManagerServerApi/saveModel', model, { headers: this.httpHeaders });
  }

  deleteModel(model): Observable<any> {
    this.httpHeaders = new HttpHeaders({ token: this.appStorage.get("token") });

    const options: Object = {
      headers: this.httpHeaders,
      body: model,
      responseType: 'text'
    };
    return this.http.delete(environment.serverBaseUrl + 'api/ModelManagerServerApi/deleteModel', options);
  }

  getAllDataSets(): Observable<any> {
    this.httpHeaders = new HttpHeaders({ token: this.appStorage.get("token") });
    return this.http.get<any[]>(environment.serverBaseUrl + 'api/ModelManagerServerApi/getAllDataSets', { headers: this.httpHeaders });
  }

  saveDataSet(dataset): Observable<any> {
    this.httpHeaders = new HttpHeaders({ token: this.appStorage.get("token") });
    return this.http.post(environment.serverBaseUrl + 'api/ModelManagerServerApi/saveDataSet', dataset, { headers: this.httpHeaders });
  }

  deleteDataSet(dataset): Observable<any> {
    this.httpHeaders = new HttpHeaders({ token: this.appStorage.get("token") });

    const options: Object = {
      headers: this.httpHeaders,
      body: dataset,
      responseType: 'text'
    };
    return this.http.delete(environment.serverBaseUrl + 'api/ModelManagerServerApi/deleteDataSet', options);
  }

  getAllAssetDocuments(): Observable<any> {
    this.httpHeaders = new HttpHeaders({ token: this.appStorage.get("token") });
    return this.http.get<any[]>(environment.serverBaseUrl + 'api/ModelManagerServerApi/getAllAssetDocuments', { headers: this.httpHeaders });
  }

  saveAssetDocument(assetDocument): Observable<any> {
    this.httpHeaders = new HttpHeaders({ token: this.appStorage.get("token") });
    return this.http.post(environment.serverBaseUrl + 'api/ModelManagerServerApi/saveAssetDocument', assetDocument, { headers: this.httpHeaders});
  }

  uploadAssetDocument(assetDocumentId, file): Observable<any> {
    const formData = new FormData();
    formData.append('file', file);
    formData.append('assetDocumentId', assetDocumentId);
    this.httpHeaders = new HttpHeaders({ token: this.appStorage.get("token") });
    return this.http.post(environment.serverBaseUrl + 'api/ModelManagerServerApi/uploadAssetDocument', formData, { headers: this.httpHeaders});
  }

  deleteAssetDocument(assetDocument): Observable<any> {
    this.httpHeaders = new HttpHeaders({ token: this.appStorage.get("token") });

    const options: Object = {
      headers: this.httpHeaders,
      body: assetDocument,
      responseType: 'text'
    };
    return this.http.delete(environment.serverBaseUrl + 'api/ModelManagerServerApi/deleteAssetDocument', options);
  }
}
