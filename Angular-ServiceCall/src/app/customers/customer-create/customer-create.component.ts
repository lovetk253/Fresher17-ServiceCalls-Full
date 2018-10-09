import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CustomersService} from "../../service/customers.service";
import {customers} from "../../model/customers.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ChargeCodesService} from "../../service/charge-codes.service";
import {chargeCode} from "../../model/charge-codes";

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private customerService: CustomersService) {
  }

  addForm: FormGroup;
  submitted = false;
  customer: customers[];

  ngOnInit() {

    this.addForm = this.formBuilder.group({
      customerId: 0,
      customerName: ['', Validators.required],
      customerAddress: ['', Validators.required],
      otherDetails: ['', Validators.required],

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


    this.customerService.createCustomer(this.addForm.value)
      .subscribe(data => {
        this.router.navigate(['/customers']);
      });
  }

}
