import { Component, OnInit } from '@angular/core';
import {ActionsModel} from "../../model/actions.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {first} from "rxjs/operators";
import {ProblemsModel} from "../../model/problems.model";
import {ProblemsService} from "../../service/problems.service";

@Component({
  selector: 'app-problems-edit',
  templateUrl: './problems-edit.component.html',
  styleUrls: ['./problems-edit.component.css']
})
export class ProblemsEditComponent implements OnInit {

  problems: ProblemsModel;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private router: Router, private problemsService: ProblemsService) { }

  ngOnInit() {
    const problemCode = localStorage.getItem("editProblems");
    if(!problemCode) {
      alert("Invalid action.")
      this.router.navigate(['problems']);
      return;
    }
    this.editForm = this.formBuilder.group({
      problemCode: [],
      problemDescription: ['', Validators.required]
    });
    this.problemsService.getProblemsById(+problemCode)
      .subscribe( data => {
        this.editForm.patchValue(data);
      });
  }

  onSubmit() {

    this.problemsService.updateProblems(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['problems']);
        },
        error => {
          alert(error);
        }
      );
  }
}
