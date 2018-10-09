import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ActionsService} from "../../service/actions.service";
import {ActionsModel} from "../../model/actions.model";
import {ChargeCodesService} from "../../service/charge-codes.service";
import {chargeCode} from "../../model/charge-codes";

@Component({
  selector: 'app-actions-create',
  templateUrl: './actions-create.component.html',
  styleUrls: ['./actions-create.component.css']
})
export class ActionsCreateComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private actionsService: ActionsService) {
  }

  addForm: FormGroup;
  submitted = false;
  action: ActionsModel[];

  ngOnInit() {

    this.addForm = this.formBuilder.group({
      actionCode: 0,
      actionDescription: ['', Validators.required],

    });

  }

  get f() {
    return this.addForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    if (this.addForm.invalid) {
      return;
    }


    this.actionsService.createActions(this.addForm.value)
      .subscribe(data => {
        this.router.navigate(['/actions']);
      });
  }
}
