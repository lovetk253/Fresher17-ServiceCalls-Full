import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {customers} from "../model/customers.model";
import {CustomersService} from "../service/customers.service";
@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {


  customer: customers[];
  constructor(private router: Router, private customerService: CustomersService) { }

  //ngOnInit() {
//    this.customerService.getAllCustomer()
//      .subscribe( data => {
//        this.customer = data;
//      });
//      });
//  }
  /*ngOnInit() {
      this.customerService.getAllCustomer()
        .subscribe( data => {
          this.customer = data;
        });

    }*/
  ngOnInit(){
    this.customerService.getAllCustomer()
      .subscribe(data => {
        this.customer =data;
      })
  }

  deleteCustomer(customer: customers): void {
    this.customerService.deleteCustomer(customer.customerId)
      .subscribe( data => {
        this.customer = this.customer.filter(u => u !== customer);
      });
  }

  editCustomer(customer: customers): void {
    localStorage.removeItem('editCustomer');
    localStorage.setItem('editCustomer', customer.customerId.toString());
    this.router.navigate(['customers/edit']);
  }

}
