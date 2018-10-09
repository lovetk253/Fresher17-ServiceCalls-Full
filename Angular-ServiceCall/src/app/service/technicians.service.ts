import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {TechniciansModel} from "../model/technicians.model";


@Injectable({
  providedIn: 'root'
})
export class TechniciansService {
  constructor(private http: HttpClient) { }
  private baseUrl = 'http://localhost:8080/technicians';

  getAllTechnicians() {
    return this.http.get<TechniciansModel[]>(this.baseUrl+'/');
  }
  getTechniciansById(id: number) {
    return this.http.get<TechniciansModel>(this.baseUrl + '/' + id);
  }

  createTechnicians(user: TechniciansModel) {
    return this.http.post(this.baseUrl, user);
  }

  updateTechnicians(user: TechniciansModel) {
    return this.http.put(this.baseUrl + '/' + user.technicianId, user);
  }

  deleteTechnicians(id: number) {
    return this.http.delete(this.baseUrl + '/' + id);
  }

}
