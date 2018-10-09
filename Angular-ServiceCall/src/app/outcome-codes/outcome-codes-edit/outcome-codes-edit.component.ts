import { Component, OnInit } from '@angular/core';
import {chargeCode} from "../../model/charge-codes";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ChargeCodesService} from "../../service/charge-codes.service";
import {first} from "rxjs/operators";
import {OutcomeCodeModel} from "../../model/outcome-code.model";
import {OutcomeCodesService} from "../../service/outcome-codes.service";

@Component({
  selector: 'app-outcome-codes-edit',
  templateUrl: './outcome-codes-edit.component.html',
  styleUrls: ['./outcome-codes-edit.component.css']
})
export class OutcomeCodesEditComponent implements OnInit {

  outcomeCode: OutcomeCodeModel;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private router: Router, private outcomeCodeService: OutcomeCodesService) { }

  ngOnInit() {
    const outcomeCodes = localStorage.getItem("editOutcomeCode");
    if(!outcomeCodes) {
      alert("Invalid action.")
      this.router.navigate(['charge-codes']);
      return;
    }
    this.editForm = this.formBuilder.group({
      outcomeCodes: [],
      outcomeDescription: ['', Validators.required]
    });
    this.outcomeCodeService.getOutcomeCodesById(+outcomeCodes)
      .subscribe( data => {
        this.editForm.patchValue(data);
      });
  }

  onSubmit() {

    this.outcomeCodeService.updateOutcomeCodes(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['outcome-codes']);
        },
        error => {
          alert(error);
        }
      );
  }

}
