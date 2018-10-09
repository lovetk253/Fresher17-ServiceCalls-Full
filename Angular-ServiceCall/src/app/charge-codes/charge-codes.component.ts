import {Component, OnInit} from '@angular/core';
import {chargeCode} from "../model/charge-codes";
import {Router} from "@angular/router";
import {ChargeCodesService} from "../service/charge-codes.service";

@Component({
  selector: 'app-charge-codes',
  templateUrl: './charge-codes.component.html',
  styleUrls: ['./charge-codes.component.css']
})
export class ChargeCodesComponent implements OnInit {
  chargeCode: chargeCode[];

  constructor(private router: Router, private chargeService: ChargeCodesService) {
  }

  ngOnInit() {
    this.chargeService.getAllChargeCode()
      .subscribe(data => {
        this.chargeCode = data;
      });
  }

  deleteChargeCode(ChargeCode: chargeCode): void {
    this.chargeService.deleteChargeCode(ChargeCode.chargeCode)
      .subscribe(data => {
        this.chargeCode = this.chargeCode.filter(u => u !== ChargeCode);
      });
  }

  editChargeCode(ChargeCode: chargeCode): void {
    localStorage.removeItem('editChargeCode');
    localStorage.setItem('editChargeCode', ChargeCode.chargeCode.toString());
    this.router.navigate(['charge-codes/edit']);
  }

}
