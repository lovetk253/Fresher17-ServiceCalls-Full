import {Component, OnInit} from '@angular/core';
import {first} from "rxjs/internal/operators";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {CustomersService} from "../../service/customers.service";
import {customers} from "../../model/customers.model";

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  customer: customers[];

  editForm: FormGroup;
  submitted = false;


  constructor(private formBuilder: FormBuilder, private router: Router, private customerService: CustomersService) {
  }

  ngOnInit() {
    this.customerService.getAllCustomer()
      .subscribe(data => {
        this.customer = data;
      });

    const customerId = localStorage.getItem('editCustomer');

    if (!customerId) {
      alert('Invalid action.');
      this.router.navigate(['customers']);
      return;
    }

    this.editForm = this.formBuilder.group({
      customerId: [],
      customerName: ['', Validators.required],
      customerAddress: ['', Validators.required],
      otherDetails: ['', Validators.required]
    });
    this.customerService.getCustomerById(+customerId)
      .subscribe(data => {
        this.editForm.patchValue(data);
      });

  }

  get f() {
    return this.editForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    if (this.editForm.invalid) {
      return;
    }
    this.customerService.updateCustomer(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['customers']);
        },
        error => {
          alert(error);
        });
  }

}
