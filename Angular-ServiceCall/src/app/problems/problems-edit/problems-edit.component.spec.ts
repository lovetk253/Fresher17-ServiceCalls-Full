import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProblemsEditComponent } from './problems-edit.component';

describe('ProblemsEditComponent', () => {
  let component: ProblemsEditComponent;
  let fixture: ComponentFixture<ProblemsEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProblemsEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProblemsEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
