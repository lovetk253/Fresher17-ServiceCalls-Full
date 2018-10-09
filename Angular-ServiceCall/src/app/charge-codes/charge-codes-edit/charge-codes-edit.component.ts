import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ChargeCodesService} from "../../service/charge-codes.service";
import {chargeCode} from "../../model/charge-codes";
import {first} from "rxjs/operators";

@Component({
  selector: 'app-charge-codes-edit',
  templateUrl: './charge-codes-edit.component.html',
  styleUrls: ['./charge-codes-edit.component.css']
})
export class ChargeCodesEditComponent implements OnInit {

  chargeCode: chargeCode;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private router: Router, private chargeCodeService: ChargeCodesService) { }

  ngOnInit() {
    const chargeCode = localStorage.getItem("editChargeCode");
    if(!chargeCode) {
      alert("Invalid action.")
      this.router.navigate(['charge-codes']);
      return;
    }
    this.editForm = this.formBuilder.group({
      chargeCode: [],
      chargeDescription: ['', Validators.required]
    });
    this.chargeCodeService.getChargeCodeById(+chargeCode)
      .subscribe( data => {
        this.editForm.patchValue(data);
      });
  }

  onSubmit() {

    this.chargeCodeService.updateChargeCode(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['charge-codes']);
        },
        error => {
          alert(error);
        }
      );
  }

}
