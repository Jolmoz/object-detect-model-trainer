import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environment/environments';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationClientService {

  httpHeaders: HttpHeaders = new HttpHeaders();

  constructor(private http: HttpClient) { }

  loginAuthentication(basicValues: string): Observable<any> {
    this.httpHeaders =
      new HttpHeaders({
        Authorization: basicValues
      });
    return this.http.post(environment.serverBaseUrl + 'api/AuthenticationManager/login', null, { headers: this.httpHeaders, responseType: "text" });
  }
}
