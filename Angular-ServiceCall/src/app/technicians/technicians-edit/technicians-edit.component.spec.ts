import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TechniciansEditComponent } from './technicians-edit.component';

describe('TechniciansEditComponent', () => {
  let component: TechniciansEditComponent;
  let fixture: ComponentFixture<TechniciansEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TechniciansEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TechniciansEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
