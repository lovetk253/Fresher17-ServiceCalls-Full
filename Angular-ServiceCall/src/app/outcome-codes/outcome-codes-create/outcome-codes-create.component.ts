import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {chargeCode} from "../../model/charge-codes";
import {OutcomeCodesService} from "../../service/outcome-codes.service";
import {OutcomeCodeModel} from "../../model/outcome-code.model";

@Component({
  selector: 'app-outcome-codes-create',
  templateUrl: './outcome-codes-create.component.html',
  styleUrls: ['./outcome-codes-create.component.css']
})
export class OutcomeCodesCreateComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private outcomeCodeService: OutcomeCodesService) {
  }

  addForm: FormGroup;
  submitted = false;
  outcomeCode: OutcomeCodeModel[];

  ngOnInit() {

    this.addForm = this.formBuilder.group({
      outcomeCodes: 0,
      outcomeDescription: ['', Validators.required],

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


    this.outcomeCodeService.createOutcomeCodes(this.addForm.value)
      .subscribe(data => {
        this.router.navigate(['/outcome-codes']);
      });
  }

}
