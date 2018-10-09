import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ProblemsModel} from "../model/problems.model";
import {ProblemsService} from "../service/problems.service";

@Component({
  selector: 'app-problems',
  templateUrl: './problems.component.html',
  styleUrls: ['./problems.component.css']
})
export class ProblemsComponent implements OnInit {

  problems: ProblemsModel[];

  constructor(private router: Router, private problemsService: ProblemsService) {
  }

  ngOnInit() {
    this.problemsService.getAllProblems()
      .subscribe(data => {
        this.problems = data;
      });
  }

  deleteProblems(problems: ProblemsModel): void {
    this.problemsService.deleteProblems(problems.problemCode)
      .subscribe(data => {
        this.problems = this.problems.filter(u => u !== problems);
      });
  }

  editProblems(problems: ProblemsModel): void {
    localStorage.removeItem('editProblems');
    localStorage.setItem('editProblems', problems.problemCode.toString());
    this.router.navigate(['problems/edit']);
  }

}
