import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {StatusCodesModel} from "../model/status-codes.model";


@Injectable({
  providedIn: 'root'
})
export class StatusCodesService {
  constructor(private http: HttpClient) { }
  private baseUrl = 'http://localhost:8080/statusCode';

  getAllStatusCodess() {
    return this.http.get<StatusCodesModel[]>(this.baseUrl+'/');
  }
  getStatusCodesById(id: number) {
    return this.http.get<StatusCodesModel>(this.baseUrl + '/' + id);
  }

  createStatusCodes(user: StatusCodesModel) {
    return this.http.post(this.baseUrl, user);
  }

  updateStatusCodes(user: StatusCodesModel) {
    return this.http.put(this.baseUrl + '/' + user.statusCode, user);
  }

  deleteStatusCodes(id: number) {
    return this.http.delete(this.baseUrl + '/' + id);
  }

}
