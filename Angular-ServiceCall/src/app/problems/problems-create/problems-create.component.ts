import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ActionsService} from "../../service/actions.service";
import {ActionsModel} from "../../model/actions.model";
import {ProblemsService} from "../../service/problems.service";
import {ProblemsModel} from "../../model/problems.model";

@Component({
  selector: 'app-problems-create',
  templateUrl: './problems-create.component.html',
  styleUrls: ['./problems-create.component.css']
})
export class ProblemsCreateComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private problemsService: ProblemsService) {
  }

  addForm: FormGroup;
  submitted = false;
  problems: ProblemsModel[];

  ngOnInit() {

    this.addForm = this.formBuilder.group({
      problemCode: 0,
      problemDescription: ['', Validators.required],

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


    this.problemsService.createProblems(this.addForm.value)
      .subscribe(data => {
        this.router.navigate(['/problems']);
      });
  }

}
