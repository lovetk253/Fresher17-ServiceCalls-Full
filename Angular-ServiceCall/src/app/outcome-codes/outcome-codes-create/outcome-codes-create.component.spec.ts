import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OutcomeCodesCreateComponent } from './outcome-codes-create.component';

describe('OutcomeCodesCreateComponent', () => {
  let component: OutcomeCodesCreateComponent;
  let fixture: ComponentFixture<OutcomeCodesCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OutcomeCodesCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OutcomeCodesCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
