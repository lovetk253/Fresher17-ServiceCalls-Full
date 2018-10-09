import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChargeCodesComponent } from './charge-codes.component';

describe('ChargeCodesComponent', () => {
  let component: ChargeCodesComponent;
  let fixture: ComponentFixture<ChargeCodesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChargeCodesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChargeCodesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
