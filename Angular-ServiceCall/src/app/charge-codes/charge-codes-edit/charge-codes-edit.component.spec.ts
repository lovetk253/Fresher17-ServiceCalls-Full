import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChargeCodesEditComponent } from './charge-codes-edit.component';

describe('ChargeCodesEditComponent', () => {
  let component: ChargeCodesEditComponent;
  let fixture: ComponentFixture<ChargeCodesEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChargeCodesEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChargeCodesEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
