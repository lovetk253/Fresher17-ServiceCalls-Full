import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {OutcomeCodeModel} from "../model/outcome-code.model";


@Injectable({
  providedIn: 'root'
})
export class OutcomeCodesService {
  constructor(private http: HttpClient) {
  }

  private baseUrl = 'http://localhost:8080/outcomeCodes';

  getAllOutcomeCodes() {
    return this.http.get<OutcomeCodeModel[]>(this.baseUrl + '/');
  }

  getOutcomeCodesById(id: number) {
    return this.http.get<OutcomeCodeModel>(this.baseUrl + '/' + id);
  }

  createOutcomeCodes(user: OutcomeCodeModel) {
    return this.http.post(this.baseUrl, user);
  }

  updateOutcomeCodes(user: OutcomeCodeModel) {
    return this.http.put(this.baseUrl, user);
  }

  deleteOutcomeCodes(id: number) {
    return this.http.delete(this.baseUrl + '/' + id);
  }

}
