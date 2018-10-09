import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TechniciansCreateComponent } from './technicians-create.component';

describe('TechniciansCreateComponent', () => {
  let component: TechniciansCreateComponent;
  let fixture: ComponentFixture<TechniciansCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TechniciansCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TechniciansCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
