import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {first} from "rxjs/operators";
import {ActionsModel} from "../../model/actions.model";
import {ActionsService} from "../../service/actions.service";

@Component({
  selector: 'app-actions-edit',
  templateUrl: './actions-edit.component.html',
  styleUrls: ['./actions-edit.component.css']
})
export class ActionsEditComponent implements OnInit {

  action: ActionsModel;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private router: Router, private actionService: ActionsService) { }

  ngOnInit() {
    const actionCode = localStorage.getItem("editActions");
    if(!actionCode) {
      alert("Invalid action.")
      this.router.navigate(['actions']);
      return;
    }
    this.editForm = this.formBuilder.group({
      actionCode: [],
      actionDescription: ['', Validators.required]
    });
    this.actionService.getActionsById(+actionCode)
      .subscribe( data => {
        this.editForm.patchValue(data);
      });
  }

  onSubmit() {

    this.actionService.updateActions(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['actions']);
        },
        error => {
          alert(error);
        }
      );
  }

}
