import {Component, OnInit} from '@angular/core';
import {chargeCode} from "../model/charge-codes";
import {Router} from "@angular/router";
import {ActionsModel} from "../model/actions.model";
import {ActionsService} from "../service/actions.service";

@Component({
  selector: 'app-actions',
  templateUrl: './actions.component.html',
  styleUrls: ['./actions.component.css']
})
export class ActionsComponent implements OnInit {

  actions: ActionsModel[];

  constructor(private router: Router, private actionsService: ActionsService) {
  }

  ngOnInit() {
    this.actionsService.getAllActions()
      .subscribe(data => {
        this.actions = data;
      });
  }

  deleteActions(actions: ActionsModel): void {
    this.actionsService.deleteActions(actions.actionCode)
      .subscribe(data => {
        this.actions = this.actions.filter(u => u !== actions);
      });
  }

  editActions(action: ActionsModel): void {
    localStorage.removeItem('editActions');
    localStorage.setItem('editActions', action.actionCode.toString());
    this.router.navigate(['actions/edit']);
  }

}
