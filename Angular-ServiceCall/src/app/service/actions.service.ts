import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActionsModel} from "../model/actions.model";


@Injectable({
  providedIn: 'root'
})
export class ActionsService {
  constructor(private http: HttpClient) {
  }

  private baseUrl = 'http://localhost:8080/actions';

  getAllActions() {
    return this.http.get<ActionsModel[]>(this.baseUrl + '/');
  }

  getActionsById(id: number) {
    return this.http.get<ActionsModel>(this.baseUrl + '/' + id);
  }

  createActions(user: ActionsModel) {
    return this.http.post(this.baseUrl, user);
  }

  updateActions(user: ActionsModel) {
    return this.http.put(this.baseUrl, user);
  }

  deleteActions(id: number) {
    return this.http.delete(this.baseUrl + '/' + id);
  }

}
