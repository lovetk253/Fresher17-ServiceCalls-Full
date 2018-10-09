import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {ProblemsModel} from "../model/problems.model";




@Injectable({
  providedIn: 'root'
})
export class ProblemsService {
  constructor(private http: HttpClient) { }
  private baseUrl = 'http://localhost:8080/problems';

  getAllProblems() {
    return this.http.get<ProblemsModel[]>(this.baseUrl+'/');
  }
  getProblemsById(id: number) {
    return this.http.get<ProblemsModel>(this.baseUrl + '/' + id);
  }

  createProblems(user: ProblemsModel) {
    return this.http.post(this.baseUrl, user);
  }

  updateProblems(user: ProblemsModel) {
    return this.http.put(this.baseUrl, user);
  }

  deleteProblems(id: number) {
    return this.http.delete(this.baseUrl + '/' + id);
  }

}
