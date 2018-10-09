import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {chargeCode} from "../model/charge-codes";


@Injectable({
  providedIn: 'root'
})
export class ChargeCodesService {
  constructor(private http: HttpClient) {
  }

  private baseUrl = 'http://localhost:8080/chargeCodes';

  getAllChargeCode() {
    return this.http.get<chargeCode[]>(this.baseUrl + '/');
  }

  getChargeCodeById(id: number) {
    return this.http.get<chargeCode>(this.baseUrl + '/' + id);
  }

  createChargeCode(user: chargeCode) {
    return this.http.post(this.baseUrl, user);
  }

  updateChargeCode(user: chargeCode) {
    return this.http.put(this.baseUrl, user);
  }

  deleteChargeCode(id: number) {
    return this.http.delete(this.baseUrl + '/' + id);
  }

}
