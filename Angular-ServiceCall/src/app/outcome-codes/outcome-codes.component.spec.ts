import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OutcomeCodesComponent } from './outcome-codes.component';

describe('OutcomeCodesComponent', () => {
  let component: OutcomeCodesComponent;
  let fixture: ComponentFixture<OutcomeCodesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OutcomeCodesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OutcomeCodesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
