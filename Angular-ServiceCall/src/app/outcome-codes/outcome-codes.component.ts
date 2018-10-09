import {Component, OnInit} from '@angular/core';
import {chargeCode} from "../model/charge-codes";
import {Router} from "@angular/router";
import {OutcomeCodeModel} from "../model/outcome-code.model";
import {OutcomeCodesService} from "../service/outcome-codes.service";

@Component({
  selector: 'app-outcome-codes',
  templateUrl: './outcome-codes.component.html',
  styleUrls: ['./outcome-codes.component.css']
})
export class OutcomeCodesComponent implements OnInit {

  outcomesCode: OutcomeCodeModel[];

  constructor(private router: Router, private outcomesCodeService: OutcomeCodesService) {
  }

  ngOnInit() {
    this.outcomesCodeService.getAllOutcomeCodes()
      .subscribe(data => {
        this.outcomesCode = data;
      });
  }

  deleteOutcomeCode(outcomeCode: OutcomeCodeModel): void {
    this.outcomesCodeService.deleteOutcomeCodes(outcomeCode.outcomeCodes)
      .subscribe(data => {
        this.outcomesCode = this.outcomesCode.filter(u => u !== outcomeCode);
      });
  }

  editOutcomeCode(outcomdeCode: OutcomeCodeModel): void {
    localStorage.removeItem('editOutcomeCode');
    localStorage.setItem('editOutcomeCode', outcomdeCode.outcomeCodes.toString());
    this.router.navigate(['outcome-codes/edit']);
  }

}
