import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProblemsCreateComponent } from './problems-create.component';

describe('ProblemsCreateComponent', () => {
  let component: ProblemsCreateComponent;
  let fixture: ComponentFixture<ProblemsCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProblemsCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProblemsCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
