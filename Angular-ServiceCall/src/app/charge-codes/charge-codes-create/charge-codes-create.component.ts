import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ChargeCodesService} from "../../service/charge-codes.service";
import {chargeCode} from "../../model/charge-codes";

@Component({
  selector: 'app-charge-codes-create',
  templateUrl: './charge-codes-create.component.html',
  styleUrls: ['./charge-codes-create.component.css']
})
export class ChargeCodesCreateComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private chargeCodeService: ChargeCodesService) {
  }

  addForm: FormGroup;
  submitted = false;
  chargeCode: chargeCode[];

  ngOnInit() {

    this.addForm = this.formBuilder.group({
      chargeCode: 0,
      chargeDescription: ['', Validators.required],

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


    this.chargeCodeService.createChargeCode(this.addForm.value)
      .subscribe(data => {
        this.router.navigate(['/charge-codes']);
      });
  }

}
