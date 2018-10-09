import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {customers} from "../model/customers.model";
import {Observable} from "rxjs/index";
import {log} from "util";
import {chargeCode} from "../model/charge-codes";

@Injectable({
  providedIn: 'root'
})
export class CustomersService {
  constructor(private http: HttpClient) {
  }

  private baseUrl = 'http://localhost:8080/customers';

  getAllCustomer() {
    return this.http.get<customers[]>(this.baseUrl + '/');
  }

  getCustomerById(id: number) {
    return this.http.get<customers>(this.baseUrl + '/' + id);
  }

  createCustomer(user: customers) {
    return this.http.post(this.baseUrl, user);
  }

  updateCustomer(user: customers) {
    return this.http.put(this.baseUrl, user);
  }

  deleteCustomer(id: number) {
    return this.http.delete(this.baseUrl + '/' + id);
  }


}
