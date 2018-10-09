import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChargeCodesCreateComponent } from './charge-codes-create.component';

describe('ChargeCodesCreateComponent', () => {
  let component: ChargeCodesCreateComponent;
  let fixture: ComponentFixture<ChargeCodesCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChargeCodesCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChargeCodesCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
