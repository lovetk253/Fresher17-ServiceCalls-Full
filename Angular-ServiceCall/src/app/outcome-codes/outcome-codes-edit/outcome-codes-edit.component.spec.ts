import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OutcomeCodesEditComponent } from './outcome-codes-edit.component';

describe('OutcomeCodesEditComponent', () => {
  let component: OutcomeCodesEditComponent;
  let fixture: ComponentFixture<OutcomeCodesEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OutcomeCodesEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OutcomeCodesEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
